/*
 *
 */
package captor.lib.intl;

public class MyIntlPortuguese {

    public static void load()  {

        MyIntl.LANG = "pt";

        //Menus
        MyIntl.MENU_BAR_FILE = "Arquivo"; 
        MyIntl.MENU_BAR_PROJECT = "Projeto"; 
        MyIntl.MENU_BAR_TOOLS = "Ferramentas"; 
        MyIntl.MENU_BAR_WINDOW = "Janela"; 
        MyIntl.MENU_BAR_HELP = "Ajuda"; 
    
        //SubMenus
        MyIntl.SUBMENU_BAR_NEW = "Novo"; 
        MyIntl.SUBMENU_BAR_EXIT = "Sair"; 
        MyIntl.SUBMENU_BAR_PROJECT = "Projeto"; 
        MyIntl.SUBMENU_BAR_OPEN = "Abrir"; 
        MyIntl.SUBMENU_BAR_CLOSE = "Fechar"; 
        MyIntl.SUBMENU_BAR_SAVE = "Salvar"; 
        MyIntl.SUBMENU_BAR_SAVEAS = "Salvar como"; 
        MyIntl.SUBMENU_BAR_BUILD = "Gerar"; 
        MyIntl.SUBMENU_BAR_CLEAN = "Limpar"; 
        MyIntl.SUBMENU_BAR_VALIDATE = "Validar"; 
        MyIntl.SUBMENU_BAR_PROPERTIES = "Propriedades"; 
        MyIntl.SUBMENU_BAR_METAMODEL_VALIDATOR = "Validador de meta-modelo"; 
        MyIntl.SUBMENU_BAR_NEW_WINDOW = "Nova janela"; 
        MyIntl.SUBMENU_BAR_SHOW_VIEW = "Mostrar view"; 
        MyIntl.SUBMENU_BAR_PREFERENCES = "Preferências"; 
        MyIntl.SUBMENU_BAR_CONSOLE = "Console"; 
        MyIntl.SUBMENU_BAR_WARNING = "Aviso"; 
        MyIntl.SUBMENU_BAR_ERROR = "Erro"; 
        MyIntl.SUBMENU_BAR_CONTENTS = "Conteúdo"; 
        MyIntl.SUBMENU_BAR_ABOUT = "Sobre"; 
    
        //Header
        MyIntl.HEADER_SAVE = "Salvar"; 
        MyIntl.HEADER_BUILD = "Gerar";
        
        //Navigator bar
        MyIntl.NAVIGATOR_LABEL = " Navegador de formulários";
        MyIntl.NAVIGATOR_ROOT_NAME = "Formulários";
    
        //Navigator popup window menus
        MyIntl.NAVIGATOR_POPUP_NEWINTERACTION = "Nova interação";
        MyIntl.NAVIGATOR_POPUP_LOAD = "Carregar";
        MyIntl.NAVIGATOR_POPUP_INSERT_AFTER = "Inserir após";
        MyIntl.NAVIGATOR_POPUP_EDIT = "Editar";
        MyIntl.NAVIGATOR_POPUP_MOVE = "Mover";
        MyIntl.NAVIGATOR_POPUP_HELP = "Ajuda";
        
        //Navigator popup window submenus
        MyIntl.NAVIGATOR_POPUP_LOAD_VARIANT = "Carregar variante";
        MyIntl.NAVIGATOR_POPUP_DELETE = "Apagar";
        MyIntl.NAVIGATOR_POPUP_MOVEUP= "Acima";
        MyIntl.NAVIGATOR_POPUP_MOVEDOWN = "Abaixo";
        
        //View Pane
        MyIntl.VIEW_PANE_CONSOLE = "Console";
        MyIntl.VIEW_PANE_ERROR = "Erro";
        MyIntl.VIEW_PANE_WARNING = "Aviso";
        
        //New project
        MyIntl.NEW_PROJECT_WINDOW_SELECT_WIZARD = "Selecione o Domínio";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_NEW_PROJECT = "Criar um novo projeto";
        MyIntl.NEW_PROJECT_WINDOW_WIZARDS = "Wizards";
        MyIntl.NEW_PROJECT_WINDOW_DOMAINS = "Dominíos";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT = "Criar um projeto Captor";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT_WORKSPACE = "Criar um projeto na área de trabalho ou em um locar externo";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_NAME = "Nome do projeto";
        MyIntl.NEW_PROJECT_WINDOW_LOCATION = "Diretório";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_LAYOUT = "Projeto";
        MyIntl.NEW_PROJECT_WINDOW_DIR = "   Directorio: ";
        MyIntl.NEW_PROJECT_WINDOW_OUTPUT_DIR = "Diretório de saída";
        MyIntl.NEW_PROJECT_WINDOW_OVERWRITE = "Sobre-escrever os arquivo sem avisar";
        MyIntl.NEW_PROJECT_WINDOW_BROWSE = "Procurar...";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_DETAILS = "Detalhes do projeto";
        MyIntl.NEW_PROJECT_WINDOW_PLEASE_CHECK = "Por favor, confira os dados antes de pressionar 'Finalizar'";
        MyIntl.PROJECT_NEW = "Novo Projeto";
    
        MyIntl.NEW_PROJECT_WINDOW_PNAME = "Nome do projeto: ";
        MyIntl.NEW_PROJECT_WINDOW_PDOMAIN = "Domínio do projeto: ";
        MyIntl.NEW_PROJECT_WINDOW_PPATH = "Caminho do projeto: ";
        MyIntl.NEW_PROJECT_WINDOW_PINPUT_FOLDER = "Diretório de entrada: ";
        MyIntl.NEW_PROJECT_WINDOW_POUTPUT_FOLDER = "Diretório de saída: ";
        
        MyIntl.NEW_PROJECT_WINDOW_BACK = "Anterior";
        MyIntl.NEW_PROJECT_WINDOW_NEXT = "Próximo";
        MyIntl.NEW_PROJECT_WINDOW_FINISH = "Finalizar";
        MyIntl.NEW_PROJECT_WINDOW_CANCEL = "Cancelar";
    
        //Project management windows
        MyIntl.PROJECT_PROPERTIES_WINDOW_TITLE = "Propriedades do projeto";
        MyIntl.PROJECT_FILE_DESCRIPTION = "Arquivos de projeto Captor (.cap)";
    
        MyIntl.PROJECT_SAVEAS_TITLE = "Salvar Projeto Como...";
        MyIntl.PROJECT_SAVEAS_NEW_PROJECT_HOME = "Novo nome do projeto: ";
        MyIntl.PROJECT_SAVEAS_LOCALIZACAO = "Localização";
        MyIntl.PROJECT_SAVEAS_PLAYOUT = "Esboço do projeto";
        MyIntl.PROJECT_SAVEAS_BROWSE = "Procurar...";
        MyIntl.PROJECT_SAVEAS_BASE_DIR = "    Diretório base: ";
        MyIntl.PROJECT_SAVEAS_OUTPUT_DIR = "Diretório de saída:";
    
        MyIntl.PROJECT_BUILD_PROGRESS = "Progresso da geração";
        MyIntl.PROJECT_BUILD_PWAIT = "Por favor espere...";
        MyIntl.PROJECT_BUILD_CANCEL = "Cancelar";
        
        MyIntl.PREFERENCES_TITLE = "Opções";
        MyIntl.PREFERENCES_CANCEL = "Cancelar";
        MyIntl.PREFERENCES_GENERAL = "Geral";
        MyIntl.PREFERENCES_INSTALL_PATH = "Instalação:  ";
        MyIntl.PREFERENCES_LOOK_AND_FEEL = "Aparência:  ";
    
        //Meta-model validator
        MyIntl.METAMODEL_VALIDATOR_CLOSE = "Fechar";
        MyIntl.METAMODEL_VALIDATOR_BROWSE = "Procurar";
        MyIntl.METAMODEL_VALIDATOR_VALIDATE = "Validar";

        //-------------------------------------------------------------------------

        //ViewPane Errors by Class source

        MyIntl.VE_XMLGENERATOR_1 = "<b><font size=\"4\">Salvando projeto: $1</font></b><br><br>";
        MyIntl.VE_XMLGENERATOR_2 = "<font color=\"#FF9966\"><b>Iniciando...</b></font><br><br>";
        MyIntl.VE_XMLGENERATOR_3 = "Erro.<br>Tentativa de gerar o XML de um elemento nulo.<br>";
        MyIntl.VE_XMLGENERATOR_4 = "<font color=\"#FF0000\"><b>Error de validação de formulário.</b></font><br><br>";
        MyIntl.VE_XMLGENERATOR_5 = "<b>Caminho do erro: </b><a href=\"$1\">$1</a><br><br>";
        MyIntl.VE_XMLGENERATOR_6 = "<b>Mensagem de erro: </b><br><br>";
        MyIntl.VE_XMLGENERATOR_7 = "<font color=\"#0000FF\">$1</font><br>";
        MyIntl.VE_XMLGENERATOR_8 = "<font color=\"#808080\"><b>Gerando XML da interação: </b></font>$1<br>";
        MyIntl.VE_XMLGENERATOR_9 = "<br><font color=\"#009933\"><b>Geração de XML completa!</b></font><br>";
        MyIntl.VE_XMLGENERATOR_10 = "<font color=\"#808080\"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gerando XML do formulário: </b></font>$1<br>";
        
        MyIntl.VE_BUILDPROJECT_1 = "<b><font color=\"#FF9966\">Geração iniciada...</font></b><br><br>";
        MyIntl.VE_BUILDPROJECT_2 = "<br><font color=\"#009933\"><b>Geração terminada!</b></font><br><br>";
        MyIntl.VE_BUILDPROJECT_3 = "<br><font color=\"#009933\"><b>Geração cancelada.</b></font><br><br>";
        MyIntl.VE_BUILDPROJECT_4 = "<font color=\"#FF9999\">Não foi possível carregar o arquivo-fonte</font> '$1 <font color=\"#FF9999\">em uma árvore DOM.'</font>.<br>Pulando a interação: '$2'<br>";
        MyIntl.VE_BUILDPROJECT_5 = "<br><b>Mensagem do mecanismos de mapeamento de transformação de templates:</b><br><font color=\"#FF0000\"><b>Não foi possíevl executar a instrução callTask:</b></font> '&lt;callTask id=\"$1\"/&gt;'<br>";
        MyIntl.VE_BUILDPROJECT_6 = "<font color=\"#FF0000\"><b>Erro da instrução For-Each:</b></font> <br><br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Statement: </b>   &lt;for-each select=\"$1\"&gt;<br><br>Não foi possível selecionar o xpath.<br><br><b>Mensagem de erro:</b> $1 formato inválido.<br>";
        MyIntl.VE_BUILDPROJECT_7 = "<b><font color=\"#FF9900\">Aviso da instrução For-Each:</font></b> <br><br>&nbsp;&nbsp;<b>Instrução:</b> &lt;for-each select=\"$1\"&gt; no arquivo: $2<br><br>&nbsp;&nbsp;&nbsp;&nbsp;<b>Mensagem:</b> O seletor do Xpath não retornou nenhum nó.<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Action:</b> Instrução ignorada.";
        MyIntl.VE_BUILDPROJECT_8 = "# Foram encontrados avisos na geração de templates.<br>Olhe a view de avisos para maiores detalhes.<br>";
        MyIntl.VE_BUILDPROJECT_9 = "<font color=\"#FF9900\"><b>Erro da instrução If: </b></font> <br><br>&nbsp;&nbsp;<b>Instrução:</b> &lt;if test=\"$1\"&gt;<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Mensagem:</b>Foi foi possível executar o teste desta instrução.<br><br>$2<br><br>Verifique a sintaxe no arquivo de mapeamento de transformação de template: $3 e tente denovo.<br>";
        MyIntl.VE_BUILDPROJECT_10 = "Não foi possível executar a task: '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_11 = "Não foi possível achar a task id = '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_12 = "Não foi possível achar o template: '$1'.<br>Corrija este erro colocando um caminho válido na marcação 'template' da tarefa com id = '$2'.<br>Você pode achar exemplos na documentação.<br>";
        MyIntl.VE_BUILDPROJECT_13 = "<br>Não foi possível executar a task com id = '$1'.<br>  Error de XPath: $2<br><br>     Solução: <br><br>         Corrija este erro colocando uma expressão válida na marcação 'newFilename'.<br><br>         Você pode achar exemplos na documentação.<br>";
        MyIntl.VE_BUILDPROJECT_14 = "Não é possível criar o diretório de saída: '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_15 = "Não é possível criar ou sobre-escrever o arquivo: '$1'. Ignorando arquivo...<br>";
        MyIntl.VE_BUILDPROJECT_16 = "Não é possível salvar o arquivo: '$1'. Ignorando...<br>";
        MyIntl.VE_BUILDPROJECT_17 = "Não é possível salvar o arquivo-fonte '$1'.<br><br>$2";
        
        MyIntl. VE_ANTRUNNER_1 = "<b><font color=\"#FF9966\">Ant iniciado...</font></b><br>";
        MyIntl. VE_ANTRUNNER_2 = "<b>Arquivo do Ant:</b> $1<br>";
        MyIntl. VE_ANTRUNNER_3 = "<br><b><font color=\"#FF0000\">Resultado da execução do Ant: erro.</font></b><br><br>$1";
        MyIntl. VE_ANTRUNNER_4 = "<br><font color=\"#009933\"><b>Resultado da execução do Ant: successo.</b></font><br><br>";
        MyIntl. VE_ANTRUNNER_5 = "<br><b><font color=\"#FF0000\">Resultado da execução do Ant: erro.</font></b><br>Mensagem do Ant: Não foi possível executar o alvo (\"target\") padrão (\"default\").<br>";
        MyIntl. VE_ANTRUNNER_6 = "<font color=\"#FF0000\"><b>Não foi possível pré-processar o arquivo do Ant:</b></font>$1<br><br>";
        MyIntl. VE_ANTRUNNER_7 = "<font color=\"#FF0000\"><b>Não foi possível pré-processar o arquivo do Ant: </b></font>$1<br>";
        MyIntl. VE_ANTRUNNER_8 = "<font color=\"#FF0000\"><b>Permissão de escrita negada.</b></font><br>";

        MyIntl.VE_BUILDUTIL_1 = "<b>Gerando arquivo:</b> ";
        MyIntl.VE_BUILDUTIL_2 = "<b>Arquivo:</b> '$1' não existente.<br>$2";
        MyIntl.VE_BUILDUTIL_3 = "Exceção: ";
        MyIntl.VE_BUILDUTIL_4 = "<b>Descrição do erro:</b><br><br>";
        MyIntl.VE_BUILDUTIL_5 = "<br><b>Nome do erro:</b> ";
        MyIntl.VE_BUILDUTIL_6 = "<b>Descrição da exceção:</b><br><br>";
        MyIntl.VE_BUILDUTIL_7 = "<br><b>Aviso:</b> não é possível criar o arquivo: $1";
        MyIntl.VE_BUILDUTIL_8 = "<font color=\"#FF0000\"><b>Não é possível transformar o item:</b></font><br><br>&nbsp;  <b>Arquivo-fonte :</b> $1.<br>&nbsp;  <b>Arquivo alvo:</b> $2.<br><b>Arquivo de template :</b> $3.<br><br>";
        MyIntl.VE_BUILDUTIL_9 = "Não foi possível rodar a safe-zone do arquivo-fonte: '$1' e do novo arquivo: '$2'<br><br>$3<br>";

        MyIntl.VE_FITBODY_CARD_1 = "Variante";
        MyIntl.VE_FITBODY_CARD_2 = "Formulário";
        
        MyIntl.VE_EXEC_FUNCTION_1 = "Instrução 'If', O atributo de teste está chamando a função: $1<br>";
        MyIntl.VE_EXEC_FUNCTION_2 = "# Existem avisos na geração do template. Olhe a view de avisos para maiores detalhes.<br>";
        MyIntl.VE_EXEC_FUNCTION_3 = "Não foi possível recuperar a expressão XPath da string: $1.<br><br>$2";
        MyIntl.VE_EXEC_FUNCTION_4 = "# Existem avisos na geração do template. Olhe a view de avisos para maiores detalhes.<br>";
        MyIntl.VE_EXEC_FUNCTION_5 = "Aviso da instrução 'If'.<br>Não foi possível recuperar a expressão XPath da string: \"$1\".<br><br><font color=\"#FF0000\"><b>Erro:</b></font><br><br>  $2.<br><br>Verifique a sintaxe desse XPath no arquivo de mapeamento de transformação de template.";

        MyIntl.VE_TAILOREXPATH_UTIL_1 = "Não foi possível avaliar a expressão XPATH: '$1'.<br>";

        MyIntl.VE_CLEAN_PROJECT_1 = "<br><b>O diretório: $1 foi apagado recursivamente.</b>";
        MyIntl.VE_SECOND_LAYER_VALIDATOR_1 = "<a href=\"$1\">$1</a><b><font color=\"#FF0000\">Erro de validação estrutural.</font></b><br><br><b>Caminho do erro: </b>$2<br><br><b>Mensagem do erro: </b><br><br>Este formulário requer pelo menos $3 formulários filhos com nome igual a: <b>$5</b><br>A configuração corrente possuir apenas $4 formulários filho(s) com esse nome.<br><br><br>Insira os formulários requeridos para conseguir uma especificação válida.<br>";
        
        MyIntl.VE_VALIDATE_PROJECT_1 = "<font color=\"#FF0000\"><b>Erro de validação de formulário.</b></font><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_2 = "<b>Caminho do erro: </b><a href=\"$1\">$1</a><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_3 = "<b>Mensagem de erro: </b><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_4 = "<font color=\"#0000FF\">$1</font><br>";

        MyIntl.VE_GENERAL_1 = "<br><b>Use a ferramenta de validação de meta-modelos para maiores detalhes.</b><br><br>";

        //-------------------------------------------------------------------------

        MyIntl.NCP_LABEL_ADD = "Adicionar";
        MyIntl.NCP_LABEL_REMOVE = "Remover";
        MyIntl.NCP_LABEL_EDIT = "Editar";
        MyIntl.NCP_LABEL_UP = "Acima";
        MyIntl.NCP_LABEL_DOWN = "Abaixo";
        MyIntl.NCP_LABEL_HELP = "Ajuda";
        MyIntl.NCP_LABEL_FE = "Elementos de formulário: ";
        MyIntl.NCP_LABEL_FECHOOSER = "Selecione o elemento de formulário";
        MyIntl.NCP_LABEL_NAME = "nome";
        MyIntl.NCP_LABEL_VALUE = "valor";
        MyIntl.NCP_LABEL_PARAMETERS = "Parâmetros: ";
        MyIntl.NCP_LABEL_ELEMENT = "Elemento:";
        MyIntl.NCP_LABEL_TEST = "Teste";
        MyIntl.NCP_LABEL_OK = "Ok";
        MyIntl.NCP_LABEL_CANCEL = "Cancelar";
        MyIntl.NCP_LABEL_FE2 = "Elemento de formulário";
        MyIntl.NCP_LABEL_NAME2 = "Nome: ";
        MyIntl.NCP_LABEL_VALUE2 = "Valor: ";
        MyIntl.NCP_LABEL_PAR_DESC = "Descrição dos parâmetros";
        MyIntl.NCP_LABEL_SHOW_PAR1 = "<p><b>Este elemento possui esses parâmetros:</b></p><br>";
        
        MyIntl.NCP_LABEL_SHOW_PAR2 = "<b>Nome do parâmetro:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR3 = "<b>&nbsp;&nbsp;Tipo do parâmetro:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR4 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Valor padrão:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR5 = "<b>Expressão regular:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR6 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Requerido:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR7 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Descrição curta:</b> ";
        
        MyIntl.NCP_LABEL_MIN_CHILDS = "Mínimo de filhos: ";
        MyIntl.NCP_LABEL_MAX_CHILDS = "Máximo de filhos: ";
        MyIntl.NCP_LABEL_NEXTFORMS = "Próximos formulários: ";
        MyIntl.NCP_LABEL_NF_ERROR1 = "Este elemento requer o parâmetro 'id'.\n";

        MyIntl.NCP_LABEL_PL1 = "Lista de parâmetros: ";

        //-------------------------------------------------------------------------

        MyIntl.MSG1 = "Por favor, crie ou abra um projeto antes de usar o painel de navegação.";
        MyIntl.MSG2 = "Um erro ocorreu na geração do template.\nOlha a view de erro para maiores detalhes.\n\n";
        MyIntl.MSG3 = "Não há nenhum projeto aberto.";
        MyIntl.MSG4 = "O projeto não está salvo.\nSalve o projeto primeiro.";
        MyIntl.MSG5 = "O arquivo $1 não foi achado.";
        MyIntl.MSG6 = "Não é possível gerar o projeto.\n\nO diretório de template: '$1' não existe.";
        MyIntl.MSG7 = "Não é possível gerar o projeto.\nO diretório de template: '$1' não é um diretório.";
        MyIntl.MSG8 = "Não é possível gerar o projeto.\n\nO diretório de saída: '$1' não existe.";
        MyIntl.MSG9 = "Não é possível gerar o projeto.\n\nO diretório de saída: '$1' não é um diretório.";
        MyIntl.MSG10 = "Não é possível gerar o projeto.\n\nNão é possível escrever no diretório: '$1'.\nPermissão negada.";
        MyIntl.MSG11 = "Não é possível gerar o projeto.\n\nFormato inválido do arquivo de saída: '$1'.";
        MyIntl.MSG12 = "Não é possível gerar o projeto.\n\nO arquivo de mapeamento: '$1' não pode ser recuperado.";
        MyIntl.MSG13 = "Foram achados erros na geração dos templates!\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG14 = "Não é possível gerar o projeto.\n\nO caminho: '$1' não existe.";
        MyIntl.MSG15 = "Não é possível gerar o projeto.\n\nO caminho: '$1' não é um diretório.";
        MyIntl.MSG16 = "Não foi possível carregar o arquivo de mapeamento: ";
        MyIntl.MSG17 = "Erro na geração.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG18 = "Não foi possível carregar o arquivo-fonte.\n";
        MyIntl.MSG19 = "Não existe nenhum projeto aberto para ser limpo.";
        MyIntl.MSG20 = "Não foi possível limpar o projeto.\nO diretório de saída: $1 não existe.";
        MyIntl.MSG21 = "Não foi possível limpar o projeto.\nO diretório de saída: $1 não é um diretório.";
        MyIntl.MSG22 = "Não foi possível limpar o projeto.\n\nO diretório de saída: $1 não pode ser apagado.";
        MyIntl.MSG23 = "Arquivos removidos.\nOlhe a view de console para maiores detalhes.";
        MyIntl.MSG24 = "Não há arquivos do projeto para serem removidos.";
        MyIntl.MSG25 = "Não há nenhum projeto aberto pelo gerenciador de projeto.";
        MyIntl.MSG26 = "Não há nenhum projeto aberto pelo gerenciador de projeto.";
        MyIntl.MSG27 = "O projeto corrente não está salvo.\nDevemos salvar o projeto antes de fecha-lo?";
        MyIntl.MSG28 = "Fechar projeto.";
        MyIntl.MSG29 = "Projecto $1 fechado.";
        MyIntl.MSG30 = "Arquivo do projeto não encontrado.";
        MyIntl.MSG31 = "Não foi possível carregar o projeto.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG32 = "Não há nenhum projeto aberto para gerar.";
        MyIntl.MSG33 = "O projeto não está salvo.\nPara gerar o projeto é necessário salvas-lo primeiro.\nVocê quer salvar o projeto?";
        MyIntl.MSG34 = "Gerar projeto.";
        MyIntl.MSG35 = "Validação executada com sucesso";
        MyIntl.MSG36 = "Não há nenhum projeto aberto pelo gerenciador de projetos.";
        MyIntl.MSG37 = "Nâo há nenhum projeto aberto para salvar.";
        MyIntl.MSG38 = "O projeto ja está salvo.";
        MyIntl.MSG39 = "Erro de validação.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG40 = "Não foi possível salvar o projeto.\nO arquivo: $1 não existe.";
        MyIntl.MSG41 = "Não foi possível salvar o projeto.\nExceção de entrada e saída durante a limpeza do arquivo de saída.\n$1";
        MyIntl.MSG42 = "Não foi possível salvar o projeto.\nMensagem: \n\n    $1";
        MyIntl.MSG43 = "Não há nenhum projeto aberto para salvar como.";
        MyIntl.MSG44 = "O diretório $1 ja existe.\nEssa ferramenta não vai sobre-escrever o conteúdo desse diretório que contém os arquivos do projeto.\nPor favor escolha outro diretório ou primeiro remova o diretório $1 para outro lugar.";
        MyIntl.MSG45 = "O projeto corrente não está salvo. Você deseja salvar o projeto antes?";
        MyIntl.MSG46 = "Salvar Como";
        MyIntl.MSG47 = "Ação cancelada.";
        MyIntl.MSG48 = "Erro.\nNão foi possível criar o diretório: $1";
        MyIntl.MSG49 = "Erro.\nNão foi possível abrir: $1";
        MyIntl.MSG50 = "Erro.\nNão foi possível copiar o diretório $1 para o diretório $2.";
        MyIntl.MSG51 = "Erro.\nNão foi possível criar: $1";
        MyIntl.MSG52 = "Erro.\nNão foi possível criar o diretório: $1";
        MyIntl.MSG53 = "Projeto criado.\nVocê quer abrir o novo projeto?";
        MyIntl.MSG54 = "Não há nenhum projeto aberto para validar.";
        MyIntl.MSG55 = "Erro de validação.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG56 = "Erro de validação.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG57 = "Projeto salvo.";
        MyIntl.MSG58 = "Não é possível instanciar a classe: $1";
        MyIntl.MSG59 = "         Erro - Existem parâmetros obrigatórios faltando.\nCorreção - Coloque os parâmetros obrigatórios na lista.\n\n           Tip -  Olhe a documentação individual de cada elementos para maiores detalhes.\n";
        MyIntl.MSG60 = "Erro.\nO campo 'id' não contém nenhum valor.";
        MyIntl.MSG61 = "O campo id não está no formato da expressão regular: $1.";
        MyIntl.MSG62 = "O valor do campo 'min childs' deve ser um número.";
        MyIntl.MSG63 = "O valor do campo 'min childs' deve ser um número.";
        MyIntl.MSG64 = "o valor do campo 'max childs' deve ser um valor maior do que '1' ou a string 'N'.";
        MyIntl.MSG65 = "o valor do campo 'max childs' value deve ser um número ou a string 'N'.";
        MyIntl.MSG66 = "O painel de id não pode ficar em branco.";
        MyIntl.MSG67 = "A lista do require precisa de pelo menos 1 item.";
        MyIntl.MSG68 = "Esse caminho ja existe na lista de caminhos.";
        MyIntl.MSG69 = "A coluna $1 está em branco.";
        MyIntl.MSG70 = "HelpSet não encontrado.";
        MyIntl.MSG71 = "Erro";
        MyIntl.MSG72 = "Não foi possível criar o HelpSet para o $1.";
        MyIntl.MSG73 = "Não foi possível criar uma URL para o $1.";
        MyIntl.MSG74 = "Não é possível apagar o formulário raíz: $1.";
        MyIntl.MSG75 = "Você tem certeza que quer apagar o formulário: \"$1\"?";
        MyIntl.MSG76 = "Apagar formulário.";
        MyIntl.MSG77 = "Esse nó pode ter apenas $1 $2 filhos.";
        MyIntl.MSG78 = "Não há ajuda disponível para este formulário.";
        MyIntl.MSG79 = "Não é possível apagar este formulário.\nO formulário pai ($1) requer pelo menos $2 \"$3\" filhos.";
        MyIntl.MSG80 = "Não há nenhum projeto aberto para salvar como.";
        MyIntl.MSG81 = "Criação do projeto cancelada.";
        MyIntl.MSG82 = "Não foi possível achar o formulário: ";
        MyIntl.MSG83 = "A aplicação não pode trabalhar apropriadamente porque você não tem permissão de escrita no diretório : $1.\nCorrija este problema e tente novamente.";
        MyIntl.MSG84 = "Validação do meta-modelo ok.";
        MyIntl.MSG85 = "Foi achado um erro no meta-modelo. Olhe a janela do MMV para maiores detalhes.";
        MyIntl.MSG86 = "O nome do projeto contém um caracter inválido.";
        MyIntl.MSG87 = "Nome do projeto inválido.\nA primeirA letra deve ser maiúscula.";
        MyIntl.MSG88 = "Nome do projeto inválido.\nEla não está no formato da expressão regular: $1";
        MyIntl.MSG89 = "Por favor, selecione um domínio antes de pressionar 'Next'.";
        MyIntl.MSG90 = "Geração completa!";
        MyIntl.MSG91 = "Geração cancelada.";
        
        //NCPMessages
        MyIntl.MSG92 = "Você tem certeza que quer remover este item?";
        MyIntl.MSG93 = "Remover elemento de formulário";
        MyIntl.MSG94 = "Você solicitou uma mudança na lista de elementos.\nVocê gostaria de remover todos os parâmetros da lista de parâmetros e carregar os parâmetros obrigatórios do novo elemento na lista de parâmetros?";
        MyIntl.MSG95 = "Mudar elemento";
        MyIntl.MSG96 = "Selecione uma linha primeiro.";
        MyIntl.MSG97 = "Selecione um elemento na caixa de seleção para ser testado.";
        MyIntl.MSG98 = "Por favor, selecione um elemento de formulário na caixa de seleção antes de pressionar o botão 'Ok'";
        MyIntl.MSG99 = "A lista de parâmetros contém alguns parâmetros que não são utilizados pelo elemento de formulário selecionado.\nEsse parâmetros serão ignorados pela ferramenta em tempo de execução.\n\nOs parâmetros que não serão utilizados são:\n\n";
        MyIntl.MSG100 = "\n\nVocê quer continuar?";
        MyIntl.MSG101 = "Parâmetros não utilizados detectados";
        MyIntl.MSG102 = "Não é possível remover o parâmetro.\nO parâmetro que você está tentando remover é tem uso obrigatório no elemento de formulário selecionado.";
        MyIntl.MSG103 = "O nome não pode estar em branco.";
        MyIntl.MSG104 = "O valor não pode estar em branco.";
        MyIntl.MSG105 = "Não é possível criar a instância do elemento.\n\n";
        MyIntl.MSG106 = "Não é possível criar a instância do elemento: $1.\n\n$2";
        MyIntl.MSG107 = "O valor do campo 'Max Childs' deve ser maior ou igual ao valor do campo 'Min Childs'.";
        MyIntl.MSG108 = "Você selecionou uma auto-relação de elemento (o próximo formulário desse elemento aponta para ele mesmo).\nVocê não pode selecionar um valor para o campo 'min childs' diferente de '0'.";
        MyIntl.MSG109 = "A lista dos próximos formulários ja contém o nó selecionado ('New Form').";
        MyIntl.MSG110 = "Você tem certeza que quer remover esse item?";
        MyIntl.MSG111 = "Remover o próximo formulário";
        MyIntl.MSG112 = "Você deve selecionar um nó \"New Form\" na árvore de formulários.";
        MyIntl.MSG114 = "Por favor, selecione um elemento de formulário na caixa de seleção antes de adicionar um parâmetro.";
        MyIntl.MSG115 = "Não foi possível achar o próximo elemento.";

        //-------------------------------------------------------------------------
    
    }

}
