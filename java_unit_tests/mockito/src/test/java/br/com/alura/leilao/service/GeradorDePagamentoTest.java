package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Pagamento;
import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class GeradorDePagamentoTest {

    private GeradorDePagamento service;

    @Mock
    private PagamentoDao dao;

    @Captor
    private ArgumentCaptor<Pagamento> captor;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        service = new GeradorDePagamento(dao);
    }

    @Test
    public void shouldCreatePaymentForAuctionWinner() {
        Leilao auction = auction();
        Lance winner = auction.getLanceVencedor();
        service.gerarPagamento(winner);

        Mockito.verify(dao).salvar(captor.capture());

        Pagamento pagamento = captor.getValue();

        Assertions.assertEquals(LocalDate.now().plusDays(1), pagamento.getVencimento());

        Assertions.assertEquals(winner.getValor(), pagamento.getValor());
        Assertions.assertFalse(pagamento.getPago());
        Assertions.assertEquals(winner.getUsuario(), pagamento.getUsuario());
        Assertions.assertEquals(auction, pagamento.getLeilao());
    }

    private Leilao auction() {

        Leilao leilao = new Leilao("Cellphone",
                new BigDecimal("500"),
                new Usuario("Fulano"));

        Lance second = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));

        leilao.propoe(second);
        leilao.setLanceVencedor(second);

        return leilao;
    }
}