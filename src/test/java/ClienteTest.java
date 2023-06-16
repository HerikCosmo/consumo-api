import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import services.Cliente;
import services.IConsumoApi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteTest {
    @Test
    public void testaGetEnderecoInfo() {
        final String apiUrl = "https://viacep.com.br/ws/63902580/json/";
        final String urlResposta = "{  \"cep\": \"63902-580\",  \"logradouro\": \"Avenida José de Freitas Queiroz\",  \"complemento\": \"\",  \"bairro\": \"Cedro\",  \"localidade\": \"Quixadá\",  \"uf\": \"CE\",  \"ibge\": \"2311306\",  \"gia\": \"\",  \"ddd\": \"88\",  \"siafi\": \"1527\"}";
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);

        IConsumoApi consumoApi = Mockito.mock(IConsumoApi.class);
        when(consumoApi.get(ArgumentMatchers.anyString())).thenReturn(urlResposta);

        Cliente cliente = new Cliente(consumoApi);

        assertEquals(cliente.getEnderecoInfo(apiUrl), urlResposta);
        verify(consumoApi, times(1)).get(urlCaptor.capture());
        assertEquals(apiUrl, urlCaptor.getValue());
    }
}
