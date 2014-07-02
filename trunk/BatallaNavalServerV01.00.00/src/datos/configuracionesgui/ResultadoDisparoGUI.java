package datos.configuracionesgui;

import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.ImageIcon;

import negocio.comunicacion.mensajes.MensajeGUI;
import negocio.comunicacion.mensajes.elementosgraficos.ElementoGUI;
import datos.imagenes.Paths;
import datos.partida.TableroMarcado.DISPARO;

public class ResultadoDisparoGUI extends Plantilla{
	private final String ImgAgua= Paths.getImgAgua();
	private final String ImgAveriado= Paths.getImgAveriado();
	private final String ImgWinner= Paths.getImgWinner();
	private final String ImgLoser= Paths.getImgLoser();
	private static int ID=0;
	public ResultadoDisparoGUI(String ClientID){
		super(ClientID);
	}
	public MensajeGUI create(DISPARO resultado,Point disparo, boolean isShoterPlayer) {
		MensajeGUI msg= new MensajeGUI();
		msg.addElemento(getResultadoGUI(resultado,disparo,isShoterPlayer));
		if(resultado==DISPARO.FINAL){
			msg.addAdapterToRemove(constants.getTableroDisparoHashCode());
		}
		return msg;
	}
	private ElementoGUI getResultadoGUI(DISPARO result,Point disparo,boolean isShoterPlayer){
		if(result==DISPARO.FINAL){
			return ElementoGUIFinal(isShoterPlayer);
		}
		
		ElementoGUI resultGUI= new ElementoGUI(""+ID);
		ID++;
		byte[] imagen=null;
		
		if (result==DISPARO.AGUA){
			File f= new File(ImgAgua);
			try {
				imagen = Files.readAllBytes(f.toPath());
			} catch (IOException e) {e.printStackTrace();}
			}
		else if(result==DISPARO.AVERIADO || result==DISPARO.HUNDIDO){
			File f= new File(ImgAveriado);
			try {
				imagen = Files.readAllBytes(f.toPath());
			} catch (IOException e) {e.printStackTrace();}
		}
			
		resultGUI.setIcon(imagen);
		if(isShoterPlayer){
			resultGUI.setBounds(constants.getTableroDisparoBounds().x+disparo.x*constants.getTAMAÑO_CASILLA(),
								constants.getTableroDisparoBounds().y+disparo.y*constants.getTAMAÑO_CASILLA(),
								constants.getTAMAÑO_CASILLA(),constants.getTAMAÑO_CASILLA());
		}
		else{
			resultGUI.setBounds(constants.getTableroColocarBounds().x+disparo.x*constants.getTAMAÑO_CASILLA(),
								constants.getTableroColocarBounds().y+disparo.y*constants.getTAMAÑO_CASILLA(),
								constants.getTAMAÑO_CASILLA(),constants.getTAMAÑO_CASILLA());
		}
		return resultGUI;
	}
	
	
	private ElementoGUI ElementoGUIFinal(boolean isWinner){
		ElementoGUI resultGUI= new ElementoGUI(""+ID);
		ID++;
		byte[] imagen=null;
		File f=null;
		if(isWinner){	f= new File(ImgWinner);}
		else{f= new File(ImgLoser);}
		try {
			imagen = Files.readAllBytes(f.toPath());
		} catch (IOException e) {e.printStackTrace();}
		resultGUI.setIcon(imagen);
		ImageIcon aux= new ImageIcon(imagen);
		
		resultGUI.setBounds(constants.getFrameBounds().width/2-aux.getIconWidth()/2,
							constants.getFrameBounds().height/2-aux.getIconHeight()/2,
							aux.getIconWidth(),aux.getIconHeight());
		return resultGUI;
	}
	
	@Override
	protected MensajeGUI create() {
		return null;
	}

}
