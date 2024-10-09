package br.com.lanchemania.lanchemania.controller;

import br.com.lanchemania.lanchemania.util.enumerate.Categoria;
import br.com.lanchemania.lanchemania.vo.CategoriaVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/constantes")
@CrossOrigin("*")
public class ConstanteController {

    @GetMapping("/categorias")
    public List<CategoriaVO> listarCategorias(){
        return Arrays.stream(Categoria.values())
                .map(categoria -> {
                    CategoriaVO vo = new CategoriaVO();
                    vo.setChave(categoria.name().toLowerCase());
                    vo.setLabel(categoria.getDescricao());
                    return vo;
                })
                .sorted((cat1, cat2) -> cat1.getLabel().compareTo(cat2.getLabel())).toList();
    }
}
