package modelo;

/**
 *
 * @author Estanislau
 */

public class Veiculo {

    private int id;
    private String nome, cor, ano, tipo, marca;

    Veiculo(int id, String nome, String cor, String ano, String tipo, String marca) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.tipo = tipo;
        this.marca = marca;
    }

    public Veiculo() {

    }

    public Veiculo(String nome, String cor, String ano, String tipo, String marca) {
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.tipo = tipo;
        this.marca = marca;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getAno() {
        return ano;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

}
