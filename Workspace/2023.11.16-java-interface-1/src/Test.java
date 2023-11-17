
public class Test {

	public static class Animale1 implements IVolante { 
		
		/**/
		@Override
		public void vola() {
			
			System.out.println("sta volando");
		}
		
	}
	public static class Animale2 implements INuotante { 
		
		/**/
		@Override
		public void nuota() {
			
			System.out.println("sta nuotantdo");
		}
	}
	// ...
	
	public static interface IVolante {
		
		void vola();
	}
	public static interface INuotante {
		
		void nuota();
	}
	
	public static void faiVolare(IVolante volante) {
		volante.vola();
	}
}
