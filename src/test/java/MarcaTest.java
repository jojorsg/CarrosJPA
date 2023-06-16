import br.com.josue.carros.Marca;
import br.com.josue.carros.dao.IMarcaDAO;
import br.com.josue.carros.dao.MarcaDAO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class MarcaTest {

    private IMarcaDAO marcaDAO;

    public MarcaTest() {
        marcaDAO = new MarcaDAO();
    }

    @Test
    public void cadastrar() {
        Marca marca = new Marca();
        marca.setCodigo("111");
        marca.setNome("Ford");
        marca = marcaDAO.cadastrar(marca);

        assertNotNull (marca);
        assertNotNull(marca.getId());
    }
}
