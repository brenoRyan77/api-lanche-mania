package br.com.lanchemania.lanchemania.service;

import br.com.lanchemania.lanchemania.mapper.ClienteMapper;
import br.com.lanchemania.lanchemania.model.Cliente;
import br.com.lanchemania.lanchemania.repository.ClienteRepository;
import br.com.lanchemania.lanchemania.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Transactional
    public void incluir(ClienteVO vo) {
        clienteRepository.findByNumero(vo.getNumero())
                .ifPresentOrElse(cliente -> {}, () -> clienteRepository.save(clienteMapper.mapToEntity(vo)));
    }
}
