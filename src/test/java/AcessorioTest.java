import br.com.josue.carros.Acessorio;
import br.com.josue.carros.Carro;
import br.com.josue.carros.Marca;
import br.com.josue.carros.dao.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AcessorioTest {

    private IAcessorioDAO acessorioDAO;
    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;

    public AcessorioTest() {

        acessorioDAO = new AcessorioDAO();
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();

    }

    @Test
    public void cadastrar() {
        Carro carro = criarCarro("7878");

        Acessorio acessorio = new Acessorio();
        acessorio.setCodigo("7878");
        acessorio.setPreco(450L);
        acessorio.setNome("Para-choque");
        acessorio.setCarro(carro);
        acessorio = acessorioDAO.cadastrar(acessorio);

        assertNotNull (acessorio);
        assertNotNull(acessorio.getId());
    }

    private Carro criarCarro(String codigo) {
        Marca marca = criarMarca();

        Carro carro = new Carro();
        carro.setCodigo(codigo);
        carro.setDescricao("Carro já fora de linha");
        carro.setPreco(53000L);
        carro.setMarca(marca);
        carro.setNome("Ecosport");
        return carroDAO.cadastrar(carro);
    }

    private Marca criarMarca() {
        Marca marca = new Marca();
        marca.setCodigo("1111");
        marca.setNome("Ford");
        return marcaDAO.cadastrar(marca);
    }
}
