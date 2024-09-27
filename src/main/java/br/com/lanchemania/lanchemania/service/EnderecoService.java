package br.com.lanchemania.lanchemania.service;

import br.com.lanchemania.lanchemania.exception.BusinessException;
import br.com.lanchemania.lanchemania.mapper.ClienteMapper;
import br.com.lanchemania.lanchemania.model.Endereco;
import br.com.lanchemania.lanchemania.repository.EnderecoRepository;
import br.com.lanchemania.lanchemania.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Transactional
    public void alterarEndereco(ClienteVO.EnderecoVO enderecoVO){
        Endereco novoEndereco = buscarEndereco(enderecoVO.getId());
        clienteMapper.updateEndereco(novoEndereco, enderecoVO);
    }

    public Endereco buscarEndereco(Long id){
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Endereço não encontrado para o id informado:", id));
    }
}
