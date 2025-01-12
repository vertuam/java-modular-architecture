package br.com.helpdev.output.restclient;


import br.com.helpdev.output.restclient.client.RandomDataApiClient;
import br.com.helpdev.usecase.port.ProtocolGeneratorClient;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@Named
public class ProtocolGeneratorClientImpl implements ProtocolGeneratorClient {

  private final RandomDataApiClient randomDataApiClient;

  @Inject
  public ProtocolGeneratorClientImpl(@RestClient final RandomDataApiClient randomDataApiClient) {
    this.randomDataApiClient = randomDataApiClient;
  }

  @Override
  public String generateNewProtocol() {
    /* Generate US-SSN to simulate protocol */
    return randomDataApiClient.generate().getValidUsSsn();
  }

}
