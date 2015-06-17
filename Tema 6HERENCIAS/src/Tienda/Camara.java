package Tienda;


	
	public class Camara extends Dispositivo {
		
		private int resH;
		private int resV;
		private boolean tieneFlash;
		
		public Camara(){
			super();
		}
		
		public Camara(float peso,float ancho,float alto,float grueso,float precio,int resH,int resV,boolean tieneFlash){
			super(peso,ancho,alto,grueso,precio);
			this.resH = resH;
			this.resV = resV;
			this.tieneFlash = tieneFlash;
		}
		
		public float getPrecio(){
			
			float precioFin = super.getPrecio() - (super.getPrecio()*0.1f);
			
			return precioFin;
		}
		
		public int getResH() {
			return resH;
		}

		public void setResH(int resH) {
			this.resH = resH;
		}

		public int getResV() {
			return resV;
		}

		public void setResV(int resV) {
			this.resV = resV;
		}

		public boolean isTieneFlash() {
			return tieneFlash;
		}

		public void setTieneFlash(boolean tieneFlash) {
			this.tieneFlash = tieneFlash;
		}
		
		public String toString(){
			String descCamara;
			
			descCamara = super.toString() + "\n"+"Resolución: "+resH+"x"+resV+" píxeles"+"\n";
			
			if(tieneFlash){
				descCamara = descCamara + "Flash: Sí";
			}else{
				descCamara = descCamara + "Flash: No";
			}
			
			return descCamara;
		}
		
	}


