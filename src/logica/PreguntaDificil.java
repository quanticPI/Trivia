package logica;

public class PreguntaDificil extends Decorador{
	
	private String[] respuestas;
	private int j = 0;
	
	public PreguntaDificil(IPregunta p){
		super(p);
		for(int i = 0; i < 2; i++)
			respuestas[0]="";
	}
	
	public void setPosibleRespuesta(String res){
		if(j < 2){
			respuestas[j] = res;
			j++;
		}
		else System.out.print("No puede insertat mas respuestas");
	}
	
	public void setRespuesta(int res){
		super.setRespuesta(res);
	}
	
	public String getTextoPregunta(){
		return super.getTextoPregunta();
	}
}
