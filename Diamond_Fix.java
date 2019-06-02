// DIAMOND CHALLENGE
// Esse código tem como objetivo gerar um diamante a partir de um numero impar informado

public class Diamond_Fix {
	// Armazena o tamanho esperado para o diamante
	private int diamondSize;
	// Usado para difinir o numero de espaços antes de cada parte do diamante
	private int initialSpaces;
	// Armazena a saída do diamante
	private String diamondOutput;
	// Constante para definir o simbolo de espaço vazio nos diamantes
	private static final String symbol_blank = " ";
	// Constante para definir o simbolo de cada fragmento do diamante
	private static final String symbol_shard = "#";
	// Constante para facilitar a leitura do codigo e usado para definir a construção do triangulo superior do diamante 
	private static final byte DIAMOND_FACTOR_TOP = -1;
	// Constante para facilitar a leitura do codigo e usado para definir a construção do triangulo inferior do diamante
	private static final byte DIAMOND_FACTOR_DOWN = 1; 
	
	// Contrutor recebe por parametro(diamondSize) o tamanho do diamante a ser retornado que por fim tem como saida um losangulo
	public Diamond_Fix(int diamondSize){
		this.diamondSize = diamondSize;
		// define o numero de espaços para a metade do tamanho esperado do diamante
		initialSpaces=(diamondSize-1)/2;
		diamondOutput = "";
		// exceção para impedir a execução de códigos com entrada par
		if(diamondSize%2==0) throw new IllegalArgumentException("Diamond size should be odd!");
		// gera a parte superior do diamante
		drawDiamondTopDown(DIAMOND_FACTOR_TOP);
		// ajusta a variavel de espaços dos diamantes
		initialSpaces+=2;
		// gera a parte inferior do diamante
		drawDiamondTopDown(DIAMOND_FACTOR_DOWN);
		// apresenta o diamante na tela
		System.out.println(diamondOutput);
	}
	
	// Metodo usado para armazenar na saída(diamondOutput) as partes superior ou inferior
	// As partes são geradas de acordo com o valor do fator recebido por parametro(diamondFactor)
	// Onde a constante "DIAMOND_FACTOR_TOP" que possuí o valor "-1" gera o triangulo superior do diamante
	// E a constante "DIAMOND_FACTOR_DOWN" que possuí o valor "1" gera o triangulo inferior do diamante
	private void drawDiamondTopDown(byte diamondFactor) {
		// variavel usada para armazenar a metade do tamanho do diamante
		int diamondHalfPart = diamondSize/2;
		// condicional usada para ajustar a parte inferior do diamante reduzindo em 1 o numero de linhas
		if(diamondFactor==DIAMOND_FACTOR_DOWN) 
			diamondHalfPart-=1;
		// laço usado para percorrer metade do tamanho total do diamante
		// pois a metade triangular superior ou inferior do diamante possui tamanho igual à metade do tamanho total
		for(int i=0;i<=diamondHalfPart;i++){
			// gera as partes em branco do lado esquerdo do triangulo
			drawDiamondPart(initialSpaces, symbol_blank);
			// gera uma parte do diamante
			drawDiamondPart(diamondSize-(initialSpaces*2), symbol_shard);
			// gera as partes em branco do lado direito do triangulo
			drawDiamondPart(initialSpaces, symbol_blank);
			initialSpaces+=diamondFactor;
			diamondOutput += "\n";
		}
	}
	
	// Metodo usado para gerar partes individuais, dado o simbolo e o tamanho da parte recebidos por parametros
	// Gera as áreas do triangulo do diamante e dos espaços
	private void drawDiamondPart(int partSize, String symbol) {
		for (int i = 0; i < partSize; i++) {
			diamondOutput += symbol;
		}
	}

	// Metodo Main que da inicio a execução ao código
	public static void main(String[] args) {
		new Diamond_Fix(31);
	}
}
