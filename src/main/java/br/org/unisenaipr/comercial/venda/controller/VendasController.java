package br.org.unisenaipr.comercial.venda.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.unisenaipr.comercial.produto.entity.Produto;
import br.org.unisenaipr.comercial.produto.service.ProdutoService;
import br.org.unisenaipr.comercial.venda.entity.Venda;
import br.org.unisenaipr.comercial.venda.service.VendasService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/vendas")
public class VendasController {
	
	
	@Autowired
	private VendasService vendasService;
		
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	public VendasController(VendasService vendasService) {
		this.vendasService = vendasService;
	}

	@RequestMapping("/vendasIndex")
	public String produtoIndex(Model theModel) {		
		List<Venda> list = vendasService.findAll();
		
		theModel.addAttribute("vendas", list);
		
		return "vendas/list";
	}
	
	@RequestMapping("/vendasSave")
	public String vendasSave(Model theModel) {		
        List<Produto> produtos = produtoService.findAll();  
        
        Venda venda = new Venda();
        venda.setDataVenda(new Date());
        
        List<Produto> prod = new ArrayList<Produto>();

        theModel.addAttribute("produtos", produtos);
		theModel.addAttribute("venda", venda);
		theModel.addAttribute("vendas", prod);
		
		return "vendas/cadastro";
	}	

//	@PostMapping("/incluirVendas")
//	public String incluirVendas(@ModelAttribute("venda") Venda vendaProduto, Model theModel) {		
//        List<Produto> produtos = produtoService.findAll();
//        theModel.addAttribute("produtos", produtos);
//        
//        Venda venda = new Venda();
//        venda.setDataVenda(new Date());
//		theModel.addAttribute("venda", venda);
//        
//        
//        Produto p = new Produto();
//        p = produtoService.findId(vendaProduto.getProdutos().get(0).getId());    
//
//        List<Produto> prod = new ArrayList<Produto>();
//        
//        System.out.println("Produto " + p.getPrecoVenda());
//        System.out.println("Qtd" + vendaProduto.getQtd());    
//        
//        double soma = vendaProduto.getQtd() *  p.getPrecoVenda();
//        
//        p.setQtdVenda(vendaProduto.getQtd());
//        p.setVlrVenda(soma);
//        
//        prod.add(p);         
//
//		theModel.addAttribute("vendas", prod);
//		
//		return "vendas/cadastro";
//	}
	
	@PostMapping("/incluirVendas")
	public String incluirVendas(@ModelAttribute("venda") Venda vendaProduto, HttpSession session, Model theModel) {		
        List<Produto> produtos = produtoService.findAll();
        theModel.addAttribute("produtos", produtos);

        Produto p = new Produto();
        p = produtoService.findId(vendaProduto.getProdutos().get(0).getId());  
       
        double soma = vendaProduto.getQtd() *  p.getPrecoVenda();

        p.setQtdVendida(vendaProduto.getQtd());
        p.setPrecoVenda(soma);

        Venda venda = new Venda();
        venda.setDataVenda(new Date());       

        Double vlrTotal = (Double) session.getAttribute("vlrTotal");

        if(vlrTotal == null) {
        	vlrTotal = soma;
        }else {
            vlrTotal += soma;  
        }
      
        session.setAttribute("venda", venda);
        session.setAttribute("vlrTotal", vlrTotal);
        
        theModel.addAttribute("venda", venda);
        theModel.addAttribute("vlrTotal", vlrTotal);
       
        
        // Recupera a lista de produtos da sessão, ou cria uma nova se não existir
        List<Produto> prod = (List<Produto>) session.getAttribute("vendaprodutos");
        if (prod == null) {
            prod = new ArrayList<>();
            session.setAttribute("vendaprodutos", prod);
        }
    	prod.add(p);
    	
    	 session.setAttribute("vendaprodutos", prod);
        theModel.addAttribute("vendaprodutos", prod);
        
		return "vendas/cadastro";
	}
	
	@PostMapping("/save-vendas")
	public String saveVenda(@ModelAttribute("vendaprodutos") Venda vendaprodutos, HttpSession session) {				
	    List<Produto> produtos = (List<Produto>) session.getAttribute("vendaprodutos");

		Venda v = new Venda();
		
		v.setQtd(produtos.size());
		v.setDataVenda(new Date());
		double vlrTotal = 0.00D;
		
		for (Produto p : produtos) {
			vlrTotal += p.getQtdVendida();
		}
		v.setVlrTotal(vlrTotal);
		v.setProdutos(produtos);
			
		vendasService.saveVenda(v);

		return "redirect:/vendas/vendasIndex";
	}	
}
