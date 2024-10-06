package br.com.senac.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "raca", nullable = false, length = 50)
    private String raca;

    @Column(name = "tipo_animal", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAnimal tipoAnimal;

    @Column(name = "nome_responsavel", nullable = false, length = 150)
    private String nomeResponsavel;

    @Column(name = "telefone_responsavel", nullable = false,length = 12)
    private String telefoneResponsavel;


    public Paciente() {
    }

    public Paciente(Integer id, String nome, Integer idade, double peso, String raca, TipoAnimal tipoAnimal, String nomeResponsavel, String telefoneResponsavel) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
        this.tipoAnimal = tipoAnimal;
        this.nomeResponsavel = nomeResponsavel;
        this.telefoneResponsavel = telefoneResponsavel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getTelefoneResponsavel() {
        return telefoneResponsavel;
    }

    public void setTelefoneResponsavel(String telefoneResponsavel) {
        this.telefoneResponsavel = telefoneResponsavel;
    }
}
