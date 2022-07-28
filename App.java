import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao = 1;

        while(opcao != 0){

            System.out.println("------------MENU------------");
            System.out.println("1 - Criar um projeto");
            System.out.println("2 - Salvar um projeto em disco");
            System.out.println("3 - Abrir um projeto em disco");
            opcao = ler.nextInt();

            switch(opcao){
                case 1:
                    Entrada();
                    Gerador();
                    break;
                
                default:
                    break;
            }            
        }
        
        ler.close();
    }

    public static void Entrada(){
        Codigo codigo = new Codigo();
        Scanner ler = new Scanner(System.in);
        System.out.println("Coloque a quantidade de classes: ");
        int numClasses = ler.nextInt();

        for(int i = 0; i < numClasses; i++){
            System.out.println("nome da classe: ");
            codigo.classe = ler.next();

            System.out.println("    nome do pacote: ");
            codigo.pacote = ler.next();

            System.out.println("    coloque a quantidade de variáveis: ");
            int qtd = ler.nextInt();

            for(int j = 1; j <= qtd; j++){
                Atributos atributo = new Atributos();
                System.out.println("  modificador: ");
                atributo.setModificador(ler.next());
                System.out.println("  tipo: ");
                atributo.setTipo(ler.next());
                System.out.println("  nome: ");
                atributo.setNome(ler.next());
                System.out.println("\n");
                codigo.addAtributos(atributo);
            }
        }
        ler.close();
    }

    public static void Gerador(){
        Codigo codigo = new Codigo();
        

        StringBuilder buffer = new StringBuilder();

        //começo 
        buffer.append("-----------RESULTADO----------- \n");
        buffer.append("@startuml").append("\n");
        buffer.append("package " + codigo.pacote + ";").append("\n\n");
        buffer.append("public class " + codigo.classe + " {").append("\n\n");

        //variaveis 
        for(Atributos a : codigo.atributos){

            buffer.append(a.modificador + " " + a.tipo + " " + a.nome + ";").append("\n");
        }

        buffer.append("\n");

        //construtor vazio 
        buffer.append("public " + codigo.classe + " () {").append("\n").append("} \n\n");

        //construtor padrão 
        buffer.append("public " + codigo.classe + " (");

        int i = 0;
        for(Atributos a : codigo.atributos){
            if( i < codigo.atributos.size() - 1){
                buffer.append(a.tipo + " " + a.nome + ", ");
            }
            else buffer.append(a.tipo + " " + a.nome);
            i++;
        }

        buffer.append(") {").append("\n");
        for(Atributos a : codigo.atributos){

            buffer.append("\tthis." + a.nome + " = " + a.nome + ";").append("\n");
        }

        buffer.append("}").append("\n\n");

        //getters e setters
        for(Atributos a : codigo.atributos){
            
            buffer.append("public " + a.tipo + " get" + upperCase(a.nome) + "() {").append("\n");
            buffer.append("\treturn " + a.nome + ";").append("\n }\n\n");
            buffer.append("public void "  + " set" + upperCase(a.nome) + "() {").append("\n");
            buffer.append("\tthis." + a.nome + " = " + a.nome + ";").append("\n }\n\n");
        }

        buffer.append("}\n").append("----------------------------------------------------");

        System.out.println(buffer);
        ler.close();
    }

        public static StringBuilder upperCase(String string){
        String aux = string.substring(1);
        char c = string.charAt(0);
        c = Character.toUpperCase(c);

        StringBuilder buffer1 = new StringBuilder();
        buffer1.append(c + aux);
        return buffer1;
    }
}
