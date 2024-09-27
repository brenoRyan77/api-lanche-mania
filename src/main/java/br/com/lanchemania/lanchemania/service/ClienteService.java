package br.com.lanchemania.lanchemania.service;

import br.com.lanchemania.lanchemania.exception.BusinessException;
import br.com.lanchemania.lanchemania.mapper.ClienteMapper;
import br.com.lanchemania.lanchemania.model.Cliente;
import br.com.lanchemania.lanchemania.repository.ClienteRepository;
import br.com.lanchemania.lanchemania.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional
    public void manter(ClienteVO vo) {
        clienteRepository.findByNumero(vo.getNumero())
                .ifPresentOrElse(cliente -> {
                    vo.setId(cliente.getId());
                    vo.getEndereco().setId(cliente.getEndereco().getId());
                    alterar(vo, cliente.getId());
                        },
                        () -> clienteRepository.save(clienteMapper.mapToEntity(vo)));
    }

    public void alterar(ClienteVO vo, Long id){
        Cliente cliente = buscar(id);
        clienteMapper.updateEntity(cliente, vo);
        enderecoService.alterarEndereco(vo.getEndereco());
    }

    public Cliente buscar(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Cliente não encontrado para o id informado:", id));
    }
}
