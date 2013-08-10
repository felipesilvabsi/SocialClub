/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.open.socialclub.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.pdf.Files;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;
import org.jrimum.utilix.ClassLoaders;

/**
 *
 * @author Felipe Silva
 */
public class GerarBoleto {

    public Boleto gerarBoleto() {
        /*
         * INFORMANDO DADOS SOBRE O CEDENTE.
         */
        Cedente cedente = new Cedente("PROJETO JRimum", "00.000.208/0001-00");

        /*
         * INFORMANDO DADOS SOBRE O SACADO.
         */
        Sacado sacado = new Sacado("JavaDeveloper Pronto Para Férias", "222.222.222-22");

        // Informando o endereço do sacado.
        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.RN);
        enderecoSac.setLocalidade("Natal");
        enderecoSac.setCep(new CEP("59064-120"));
        enderecoSac.setBairro("Grande Centro");
        enderecoSac.setLogradouro("Rua poeta dos programas");
        enderecoSac.setNumero("1");
        sacado.addEndereco(enderecoSac);

        /*
         * INFORMANDO DADOS SOBRE O SACADOR AVALISTA.
         */
        SacadorAvalista sacadorAvalista = new SacadorAvalista("JRimum Enterprise", "00.000.000/0001-91");

        // Informando o endereço do sacador avalista.
        Endereco enderecoSacAval = new Endereco();
        enderecoSacAval.setUF(UnidadeFederativa.DF);
        enderecoSacAval.setLocalidade("Brasília");
        enderecoSacAval.setCep(new CEP("59000-000"));
        enderecoSacAval.setBairro("Grande Centro");
        enderecoSacAval.setLogradouro("Rua Eternamente Principal");
        enderecoSacAval.setNumero("001");
        sacadorAvalista.addEndereco(enderecoSacAval);

        /*
         * INFORMANDO OS DADOS SOBRE O TÍTULO.
         */

        // Informando dados sobre a conta bancária do título.
        ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_DO_BRASIL.create());
        contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
        contaBancaria.setCarteira(new Carteira(30));
        contaBancaria.setAgencia(new Agencia(1234, "1"));

        Titulo titulo = new Titulo(contaBancaria, sacado, cedente, sacadorAvalista);
        titulo.setNumeroDoDocumento("123456");
        titulo.setNossoNumero("99345678912");
        titulo.setDigitoDoNossoNumero("5");
        titulo.setValor(BigDecimal.valueOf(0.23));
        titulo.setDataDoDocumento(new Date());
        titulo.setDataDoVencimento(new Date());
        titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
        titulo.setAceite(Aceite.A);
        titulo.setDesconto(new BigDecimal(0.05));
        titulo.setDeducao(BigDecimal.ZERO);
        titulo.setMora(BigDecimal.ZERO);
        titulo.setAcrecimo(BigDecimal.ZERO);
        titulo.setValorCobrado(BigDecimal.ZERO);

        /*
         * INFORMANDO OS DADOS SOBRE O BOLETO.
         */
        Boleto boleto = new Boleto(titulo);

        boleto.setLocalPagamento("Pagável preferencialmente na Rede X ou em "
                + "qualquer Banco até o Vencimento.");
        boleto.setInstrucaoAoSacado("Senhor sacado, sabemos sim que o valor "
                + "cobrado não é o esperado, aproveite o DESCONTÃO!");
        boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
        boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
        boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
        boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
        boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
        boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
        boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
        boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");

        return boleto;
        /*
         * GERANDO O BOLETO BANCÁRIO.
         */
        // Instanciando um objeto "BoletoViewer", classe responsável pela
        // geração do boleto bancário.
        //BoletoViewer boletoViewer = new BoletoViewer(boleto);

        // Gerando o arquivo. No caso o arquivo mencionado será salvo na mesma
        // pasta do projeto. Outros exemplos:
        // WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
        // LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
        //File arquivoPdf = boletoViewer.getPdfAsFile("C:/MeuPrimeiroBoleto.pdf");

        // Mostrando o boleto gerado na tela.
        //mostreBoletoNaTela(arquivoPdf);
    }

    public File gerarCarneBoleto() {
        List<Boleto> boletos = new ArrayList<Boleto>();

        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());
        boletos.add(gerarBoleto());

        
        

        //File templatePersonalizado = new File(ClassLoaders.getResource("C:/BoletoCarne3PorPagina.pdf").getFile());
        File templatePersonalizado = new File("C:/BoletoCarne3PorPagina.pdf");
        
        

        return groupInPages(boletos, "C:\\Users\\Felipe Silva\\Desktop\\Carne3PorPagina.pdf", templatePersonalizado);
        
        

    }

    private static File groupInPages(List<Boleto> boletos, String filePath, File templatePersonalizado) {

        File arq = null;
        BoletoViewer boletoViewer = new BoletoViewer(boletos.get(0));
        boletoViewer.setTemplate(templatePersonalizado);

        List<byte[]> boletosEmBytes = new ArrayList<byte[]>(boletos.size());

        //Adicionando os PDF, em forma de array de bytes, na lista.
        for (Boleto bop : boletos) {
            boletosEmBytes.add(boletoViewer.setBoleto(bop).getPdfAsByteArray());
        }

        try {

            //Criando o arquivo com os boletos da lista
            arq = Files.bytesToFile(filePath, mergeFilesInPages(boletosEmBytes));

        } catch (Exception e) {
            throw new IllegalStateException("Erro durante geração do PDF! Causado por " + e.getLocalizedMessage(), e);
        }

        return arq;
    }

    public static byte[] mergeFilesInPages(List<byte[]> pdfFilesAsByteArray) throws DocumentException, IOException {

        Document document = new Document();
        ByteArrayOutputStream byteOS = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(document, byteOS);

        document.open();

        PdfContentByte cb = writer.getDirectContent();
        float positionAnterior = 0;

        //Para cada arquivo da lista, cria-se um PdfReader, responsável por ler o arquivo PDF e recuperar informações dele.
        for (byte[] pdfFile : pdfFilesAsByteArray) {

            PdfReader reader = new PdfReader(pdfFile);

            //Faz o processo de mesclagem por página do arquivo, começando pela de número 1.
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {

                float documentHeight = cb.getPdfDocument().getPageSize().getHeight();

                //Importa a página do PDF de origem
                PdfImportedPage page = writer.getImportedPage(reader, i);
                float pagePosition = positionAnterior;

                /*
                 * Se a altura restante no documento de destino form menor que a altura do documento,
                 * cria-se uma nova página no documento de destino.
                 */
                if ((documentHeight - positionAnterior) <= page.getHeight()) {
                    document.newPage();
                    pagePosition = 0;
                    positionAnterior = 0;
                }

                //Adiciona a página ao PDF destino
                cb.addTemplate(page, 0, pagePosition);

                positionAnterior += page.getHeight();
            }
        }

        byteOS.flush();
        document.close();

        byte[] arquivoEmBytes = byteOS.toByteArray();
        byteOS.close();

        return arquivoEmBytes;
    }
}
