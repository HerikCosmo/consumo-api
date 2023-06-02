import services.Cliente;
import services.ConsumoApi;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(new ConsumoApi());

        System.out.println(cliente.getEnderecoInfo("https://viacep.com.br/ws/63902580/json/"));
    }
}
