package services;

public class Cliente {
    IConsumoApi consumoApi;

    public Cliente(IConsumoApi consumoApi) {
        this.consumoApi = consumoApi;
    }

    public String getEnderecoInfo(String url) {
        return consumoApi.get(url);
    }
}
