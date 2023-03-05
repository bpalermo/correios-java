package dev.palermo.correios.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ClientTest {

  static AtendeCliente client;

  @BeforeAll
  public static void setup() {
    AtendeClienteService service = new AtendeClienteService();
    client = service.getAtendeClientePort();
  }

  @Test
  public void clientTest() {
    assertNotNull(client);
  }

  @Test
  public void addressTest() throws SQLException_Exception, SigepClienteException {
    EnderecoERP address = client.consultaCEP("22630012");
    assertNotNull(address);
    assertNotNull(address.end);
    assertNotEquals("", address.end);
    assertEquals("Barra da Tijuca", address.bairro);
    assertEquals("Rio de Janeiro", address.cidade);
    assertEquals("RJ", address.uf);
  }
}
