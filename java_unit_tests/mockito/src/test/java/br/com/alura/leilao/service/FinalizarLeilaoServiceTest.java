package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.LeilaoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FinalizarLeilaoServiceTest {

    private FinalizarLeilaoService service;

    @Mock
    private LeilaoDao dao;

    @Mock
    private EnviadorDeEmails enviadorDeEmails;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
        service = new FinalizarLeilaoService(dao, enviadorDeEmails);
    }

    @Test
    public void shouldFinishAAuction() {

        List<Leilao> auctions = auctions();
        Mockito.when(dao.buscarLeiloesExpirados()).thenReturn(auctions);

        service.finalizarLeiloesExpirados();

        Leilao leilao = auctions.get(0);
        Assertions.assertTrue(leilao.isFechado());
        Assertions.assertEquals(new BigDecimal("900"), leilao.getLanceVencedor().getValor());
        Mockito.verify(dao).salvar(leilao);
    }

    @Test
    public void shouldSendEmailToHighestBidder() {
        List<Leilao> auctions = auctions();
        Mockito.when(dao.buscarLeiloesExpirados()).thenReturn(auctions);

        service.finalizarLeiloesExpirados();

        Leilao leilao = auctions.get(0);
        Assertions.assertTrue(leilao.isFechado());
        Lance highestBidder = leilao.getLanceVencedor();

        Mockito.verify(enviadorDeEmails).enviarEmailVencedorLeilao(highestBidder);
    }

    @Test
    public void shouldNotSendEmailWhenSaveMethodFails() {
        List<Leilao> auctions = auctions();
        Mockito.when(dao.buscarLeiloesExpirados()).thenReturn(auctions);

        Mockito.when(dao.salvar(Mockito.any())).thenThrow(RuntimeException.class);
        try{
            service.finalizarLeiloesExpirados();
            Mockito.verifyNoInteractions(enviadorDeEmails);
        } catch (Exception e) {}

    }

    private List<Leilao> auctions(){
        List<Leilao> list = new ArrayList<>();

        Leilao leilao = new Leilao("Cellphone",
                new BigDecimal("500"),
                new Usuario("Fulano"));

        Lance first = new Lance(new Usuario("Beltrano"), new BigDecimal("600"));
        Lance second = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));

        leilao.propoe(first);
        leilao.propoe(second);

        list.add(leilao);

        return list;
    }
}