import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import services.Cliente;
import services.IConsumoApi;

public class ClienteTest {
    @Test
    public void testaGetEnderecoInfo() {
        String url = "https://viacep.com.br/ws/63902580/json/";
        String urlResposta = "{  \"cep\": \"63902-580\",  \"logradouro\": \"Avenida José de Freitas Queiroz\",  \"complemento\": \"\",  \"bairro\": \"Cedro\",  \"localidade\": \"Quixadá\",  \"uf\": \"CE\",  \"ibge\": \"2311306\",  \"gia\": \"\",  \"ddd\": \"88\",  \"siafi\": \"1527\"}";

        IConsumoApi consumoApi = Mockito.mock(IConsumoApi.class);
        Mockito.when(consumoApi.get(url)).thenReturn(urlResposta);

        Cliente cliente = new Cliente(consumoApi);

        Assert.assertEquals(cliente.getEnderecoInfo(url), urlResposta);
    }
}
