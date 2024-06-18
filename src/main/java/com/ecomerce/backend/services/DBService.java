package com.ecomerce.backend.services;

import com.ecomerce.backend.entities.Endereco;
import com.ecomerce.backend.entities.Pessoa;
import com.ecomerce.backend.entities.Produto;
import com.ecomerce.backend.entities.Usuario;
import com.ecomerce.backend.entities.enums.Perfil;
import com.ecomerce.backend.repositories.EnderecoRepository;
import com.ecomerce.backend.repositories.PessoaRepository;
import com.ecomerce.backend.repositories.ProductRepository;
import com.ecomerce.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DBService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void instanciaDB() {
        Pessoa p1 = new Pessoa(null, "Ana Julia", "040.198.751-54", "01/10/2002");
        Endereco ed1 = new Endereco(null, "Rua Madri 6", "Goiânia", "GO", "74369-046", "SN", "");
        ed1.setPessoa(p1);
        p1.setEndereco(ed1);

        Pessoa p2 = new Pessoa(null, "Joao teste", "47.395.704-8", "01/10/2002");
        Endereco ed2 = new Endereco(null, "Rua São João", "Goiânia", "GO", "74354-826", "SN", "");
        ed2.setPessoa(p2);
        p2.setEndereco(ed2);

        Usuario u1 = new Usuario(null, "jujuAdm@gmail.com", "123");
        u1.addPerfil(Perfil.ADMIN);

        Usuario u2 = new Usuario(null, "jujuCliente@gmail.com", "123");
        u2.setPessoa(p1);
        u2.addPerfil(Perfil.CLIENTE);

        Usuario u3 = new Usuario(null, "joao@gmail.com", "123");
        u3.setPessoa(p2);
        u3.addPerfil(Perfil.CLIENTE);

        Produto produto = new Produto();
        produto.getId();
        Produto produto1 = new Produto(null, "Camiseta Lã Azul","Produto Artesanal feito de lã", 29000.27, 2);
        Produto produto2 = new Produto(null, "Camiseta Lã Preta","Produto Artesanal feito de lã", 1299.99, 2);
        Produto produto3 = new Produto(null, "Camiseta Lã Vermelha","Produto Artesanal feito de lã", 290.5, 2);

        this.productRepository.save(produto1);
        this.productRepository.save(produto2);
        this.productRepository.save(produto3);

        pessoaRepository.save(p1);
        enderecoRepository.save(ed1);

        pessoaRepository.save(p2);
        enderecoRepository.save(ed2);

        usuarioRepository.save(u1);
        usuarioRepository.save(u2);
        usuarioRepository.save(u3);
    }
}