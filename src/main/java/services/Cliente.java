package services;

public class Cliente {
    IConsumoApi consumoApi;

    public Cliente(IConsumoApi consumoApi) {
        this.consumoApi = consumoApi;
    }

    public String getEnderecoInfo(String url) {
        String  dados = consumoApi.get(url);
        return dados;
    }
}
