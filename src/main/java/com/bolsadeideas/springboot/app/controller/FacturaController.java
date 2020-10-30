package com.bolsadeideas.springboot.app.controller;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import com.bolsadeideas.springboot.app.models.entity.Producto;
import com.bolsadeideas.springboot.app.models.service.IClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
    @Autowired
    IClienteService clienteService;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/form/{clienteId}")
    public String crear(@PathVariable (name = "clienteId") Long clienteId, Map<String, Object> modelo, RedirectAttributes flash){
        Cliente cliente = clienteService.findOne(clienteId);
        if (cliente == null){
            flash.addFlashAttribute("El cliente no exixte en la base de datos");
            return "redirect:/listar";
        }
        Factura factura = new Factura();
        factura.setCliente(cliente);

        modelo.put("factura",factura);
        modelo.put("titulo","Crear factura");
        return "factura/form";
    }

    @GetMapping(value = "/cargar-productos/{term}",produces = {"application/json"})
    public @ResponseBody List<Producto> caragarProductos(@PathVariable String term){
        return clienteService.findByNombre(term);
    }
    @PostMapping("/form")
    public String guardar(@Valid Factura factura, BindingResult result, Model modelo,
                          @RequestParam(name = "item_id[]", required = false) Long [] itemId,
                          @RequestParam(name = "cantidad[]", required = false) Integer [] cantidad,
                          RedirectAttributes flash, SessionStatus status){
        if (result.hasErrors()){
            modelo.addAttribute("titulo","Crear factura");
            return "factura/form";
        }
        if (itemId == null || itemId.length == 0){
            modelo.addAttribute("titulo","Crear factura");
            modelo.addAttribute("error","Error: la factura no puede estar vacia");
            return "factura/form";
        }
        for(int i=0;i < itemId.length;i++){
            Producto producto = clienteService.findProductoById(itemId[i]);

            ItemFactura linea = new ItemFactura();
            linea.setCantidad(cantidad[i]);
            linea.setProducto(producto);
            factura.addItemFactura(linea);

            log.info("ID: "+itemId[i].toString()+", cantidad: "+cantidad[i].toString());
        }
        clienteService.saveFactura(factura);
        status.setComplete();
        flash.addFlashAttribute("success","factura creada con exito");
        return "redirect:/ver/"+factura.getCliente().getId();
    }
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id,Model modelo,RedirectAttributes flash){
            Factura factura = clienteService.fetchFacturaByIdWithClienteWhithItemFacturaWhithProducto(id);//findFacturaById(id);

            if (factura == null){
                flash.addFlashAttribute("error","La factura no existe en la BBDD");
                return "redirec:/listar";
            }
            modelo.addAttribute("factura",factura);
            modelo.addAttribute("titulo","Factura: ".concat(factura.getDescripcion()));
            return "factura/ver";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id,RedirectAttributes flash){
        Factura factura = clienteService.findFacturaById(id);
        if (factura != null){
            clienteService.deleteFactura(id);
            flash.addFlashAttribute("success","Factura Eliminada con exito!");
            return "redirect:/ver/"+factura.getCliente().getId();
        }
        flash.addFlashAttribute("error","La factura n existe en la base de datos");
        return "redirect:/listar";
    }
}
