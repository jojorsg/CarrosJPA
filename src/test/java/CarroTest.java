import br.com.josue.carros.Carro;
import br.com.josue.carros.Marca;
import br.com.josue.carros.dao.CarroDAO;
import br.com.josue.carros.dao.ICarroDAO;
import br.com.josue.carros.dao.IMarcaDAO;
import br.com.josue.carros.dao.MarcaDAO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CarroTest {

    private ICarroDAO carroDAO;
    private IMarcaDAO marcaDAO;

    public CarroTest() {
        carroDAO = new CarroDAO();
        marcaDAO = new MarcaDAO();
    }

    @Test
    public void cadastrar() {
        Marca marca = criarMarca("4545");

        Carro carro = new Carro();
        carro.setCodigo("4545");
        carro.setDescricao("Carro já fora de linha");
        carro.setPreco(53000L);
        carro.setNome("Ecosport");
        carro.setMarca(marca);
        carro = carroDAO.cadastrar(carro);

        assertNotNull (carro);
        assertNotNull(carro.getId());
    }

    private Marca criarMarca(String codigo) {
        Marca marca = new Marca();
        marca.setCodigo(codigo);
        marca.setNome("Ford");
        return marcaDAO.cadastrar(marca);
    }
}
