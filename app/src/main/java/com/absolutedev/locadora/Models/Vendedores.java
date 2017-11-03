package com.absolutedev.locadora.Models;

import java.io.Serializable;

/**
 * Created by Infranet on 03/11/2017.
 */

public class Vendedores implements Serializable {
        public Long id;
        public String nome = " ";
        public int cpf;
        public int telefone = 0;
        public String email = "";

        public Vendedores(String nome, int cpf, int telefone, String email){
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.email = email;
        }
        public Vendedores(Long id, String nome, int cpf, int telefone, String email){
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.telefone = telefone;
            this.email = email;
        }

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

        public int getCpf() {
            return cpf;
        }

        public void setCpf(int cpf) {
            this.cpf = cpf;
        }

        public int getTelefone() {
            return telefone;
        }

        public void setTelefone(int telefone) {
            this.telefone = telefone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
}
