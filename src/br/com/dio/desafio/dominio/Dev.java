package br.com.dio.desafio.dominio;

import java.util.HashSet;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new HashSet<>();
    private Set<Conteudo> conteudosConcluidos = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
    }

    public void progredir() {
        if (!conteudosInscritos.isEmpty()) {
            Conteudo conteudo = conteudosInscritos.iterator().next();
            conteudosInscritos.remove(conteudo);
            conteudosConcluidos.add(conteudo);
        }
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }
}
