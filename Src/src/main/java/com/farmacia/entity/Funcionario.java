package com.farmacia.model;

import java.math.BigDecimal; // Para o salário

public class Funcionario {

    // 1. Atributos (campos privados)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String nome;
    private String cpf;
    private String cargo;
    private BigDecimal salario; // Recomendado usar BigDecimal para dinheiro
    private String dataAdmissao; // Pode ser tipo LocalDate, mas String por enquanto para simplificar
    private String login;
    private String senha; // Em um sistema real, essa seria criptografada!

    // 2. Construtores e Getters/Setters virão aqui
}