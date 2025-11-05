package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Consultoria(){

    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack() == true){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double total = 0.0;
        for(Desenvolvedor desenvolvedor : desenvolvedores){
            total += desenvolvedor.calcularSalario();
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer total = 0;
        for(Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                total++;
            }
        }
        return total;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> retornarSalario = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores){
            if (desenvolvedor.calcularSalario() >= salario){
                retornarSalario.add(desenvolvedor);
            }
        }
        return retornarSalario;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()){
            return null;
        }
        else {
            Desenvolvedor retornarSalario = desenvolvedores.get(0);
            for (Desenvolvedor desenvolvedor : desenvolvedores) {
                if (desenvolvedor.calcularSalario() < retornarSalario.calcularSalario()) {
                    retornarSalario = desenvolvedor;
                }
            }
            return retornarSalario;
        }
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> retornaPorTecnologia = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia) ){
                    retornaPorTecnologia.add(desenvolvedor);
                }
            }
            else if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia) || ((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia)){
                    retornaPorTecnologia.add(desenvolvedor);
                }
            }
        }
        return retornaPorTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double retornaTotalPorTecnologia = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorWeb) {
                if (((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) || ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia) ){
                    retornaTotalPorTecnologia += desenvolvedor.calcularSalario();
                }
            }
            else if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia) || ((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia)){
                    retornaTotalPorTecnologia += desenvolvedor.calcularSalario();
                }
            }
        }
        return retornaTotalPorTecnologia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }


}
