import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    

public void cria(InputStream inputStream, String nomeArquivo) throws Exception{

    //leitura da imagem
    //InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
    //URL inputStream = new URL("https://m.media-amazon.com/images/M/MV5BYWI4MzIxYzUtMmIzNC00Mzg0LTgwZTItNTk5YWExODJmZDZiXkEyXkFqcGdeQXVyMTMzNDExODE5.jpg");
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    //cria nova imagem em memória com trasnparência e com tamanho novo
     int largura = imagemOriginal.getWidth();
     int altura = imagemOriginal.getHeight();
     int novaAltura = altura + 200;
     BufferedImage novaImagem = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);
    //copiar a imagem original pra nova imagem(em moria)
     Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
      graphics.drawImage(imagemOriginal, 0, 0, null);
      //configura a fonte
      var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
      graphics.setFont(fonte);
      graphics.setColor(Color.YELLOW);
    //escrever uma frase na nova imagem
      graphics.drawString("TOPZERA",100,novaAltura - 100);
    //escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo)); 
   }
   //public static void main(String[] args) throws Exception {
     // var geradora = new GeradoraDeFigurinhas();
     // geradora.cria();
  // }
}
