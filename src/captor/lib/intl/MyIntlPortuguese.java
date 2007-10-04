/*
Copyright (C) 2005 Edison Kicho Shimabukuro Junior <edison.kicho@gmail.com>

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package captor.lib.intl;

public class MyIntlPortuguese
{
    public static void load()
    {
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
        MyIntl.NEW_PROJECT_WINDOW_SELECT_WIZARD = "Selecione o Dom�nio";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_NEW_PROJECT = "Criar um novo projeto";
        MyIntl.NEW_PROJECT_WINDOW_WIZARDS = "Wizards";
        MyIntl.NEW_PROJECT_WINDOW_DOMAINS = "Domin�os";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT = "Criar um projeto Captor";
        MyIntl.NEW_PROJECT_WINDOW_CREATE_CAPTOR_PROJECT_WORKSPACE = "Criar um projeto na �rea de trabalho ou em um locar externo";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_NAME = "Nome do projeto";
        MyIntl.NEW_PROJECT_WINDOW_LOCATION = "Diret�rio";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_LAYOUT = "Projeto";
        MyIntl.NEW_PROJECT_WINDOW_DIR = "   Directorio: ";
        MyIntl.NEW_PROJECT_WINDOW_OUTPUT_DIR = "Diret�rio de sa�da";
        MyIntl.NEW_PROJECT_WINDOW_OVERWRITE = "Sobre-escrever os arquivo sem avisar";
        MyIntl.NEW_PROJECT_WINDOW_BROWSE = "Procurar...";
        MyIntl.NEW_PROJECT_WINDOW_PROJECT_DETAILS = "Detalhes do projeto";
        MyIntl.NEW_PROJECT_WINDOW_PLEASE_CHECK = "Por favor, confira os dados antes de pressionar 'Finalizar'";
        MyIntl.PROJECT_NEW = "Novo Projeto";
    
        MyIntl.NEW_PROJECT_WINDOW_PNAME = "Nome do projeto: ";
        MyIntl.NEW_PROJECT_WINDOW_PDOMAIN = "Dom�nio do projeto: ";
        MyIntl.NEW_PROJECT_WINDOW_PPATH = "Caminho do projeto: ";
        MyIntl.NEW_PROJECT_WINDOW_PINPUT_FOLDER = "Diret�rio de entrada: ";
        MyIntl.NEW_PROJECT_WINDOW_POUTPUT_FOLDER = "Diret�rio de sa�da: ";
        
        MyIntl.NEW_PROJECT_WINDOW_BACK = "Anterior";
        MyIntl.NEW_PROJECT_WINDOW_NEXT = "Pr�ximo";
        MyIntl.NEW_PROJECT_WINDOW_FINISH = "Finalizar";
        MyIntl.NEW_PROJECT_WINDOW_CANCEL = "Cancelar";
    
        //Project management windows
        MyIntl.PROJECT_PROPERTIES_WINDOW_TITLE = "Propriedades do projeto";
        MyIntl.PROJECT_FILE_DESCRIPTION = "Arquivos de projeto Captor (.cap)";
    
        MyIntl.PROJECT_SAVEAS_TITLE = "Salvar Projeto Como...";
        MyIntl.PROJECT_SAVEAS_NEW_PROJECT_HOME = "Novo nome do projeto: ";
        MyIntl.PROJECT_SAVEAS_LOCALIZACAO = "Localiza��o";
        MyIntl.PROJECT_SAVEAS_PLAYOUT = "Esbo�o do projeto";
        MyIntl.PROJECT_SAVEAS_BROWSE = "Procurar...";
        MyIntl.PROJECT_SAVEAS_BASE_DIR = "    Diret�rio base: ";
        MyIntl.PROJECT_SAVEAS_OUTPUT_DIR = "Diret�rio de sa�da:";
    
        MyIntl.PROJECT_BUILD_PROGRESS = "Progresso da gera��o";
        MyIntl.PROJECT_BUILD_PWAIT = "Por favor espere...";
        MyIntl.PROJECT_BUILD_CANCEL = "Cancelar";
        
        MyIntl.PREFERENCES_TITLE = "Op��es";
        MyIntl.PREFERENCES_CANCEL = "Cancelar";
        MyIntl.PREFERENCES_GENERAL = "Geral";
        MyIntl.PREFERENCES_INSTALL_PATH = "Instala��o:  ";
        MyIntl.PREFERENCES_LOOK_AND_FEEL = "Apar�ncia:  ";
    
        //Meta-model validator
        MyIntl.METAMODEL_VALIDATOR_CLOSE = "Fechar";
        MyIntl.METAMODEL_VALIDATOR_BROWSE = "Procurar";
        MyIntl.METAMODEL_VALIDATOR_VALIDATE = "Validar";

        //-------------------------------------------------------------------------

        //ViewPane Errors by Class source

        MyIntl.VE_XMLGENERATOR_1 = "<b><font size=\"4\">Salvando projeto: $1</font></b><br><br>";
        MyIntl.VE_XMLGENERATOR_2 = "<font color=\"#FF9966\"><b>Iniciando...</b></font><br><br>";
        MyIntl.VE_XMLGENERATOR_3 = "Erro.<br>Tentativa de gerar o XML de um elemento nulo.<br>";
        MyIntl.VE_XMLGENERATOR_4 = "<font color=\"#FF0000\"><b>Error de valida��o de formul�rio.</b></font><br><br>";
        MyIntl.VE_XMLGENERATOR_5 = "<b>Caminho do erro: </b><a href=\"$1\">$1</a><br><br>";
        MyIntl.VE_XMLGENERATOR_6 = "<b>Mensagem de erro: </b><br><br>";
        MyIntl.VE_XMLGENERATOR_7 = "<font color=\"#0000FF\">$1</font><br>";
        MyIntl.VE_XMLGENERATOR_8 = "<font color=\"#808080\"><b>Gerando XML da intera��o: </b></font>$1<br>";
        MyIntl.VE_XMLGENERATOR_9 = "<br><font color=\"#009933\"><b>Gera��o de XML completa!</b></font><br>";
        MyIntl.VE_XMLGENERATOR_10 = "<font color=\"#808080\"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gerando XML do formul�rio: </b></font>$1<br>";
        
        MyIntl.VE_BUILDPROJECT_1 = "<b><font color=\"#FF9966\">Gera��o iniciada...</font></b><br><br>";
        MyIntl.VE_BUILDPROJECT_2 = "<br><font color=\"#009933\"><b>Gera��o terminada!</b></font><br><br>";
        MyIntl.VE_BUILDPROJECT_3 = "<br><font color=\"#009933\"><b>Gera��o cancelada.</b></font><br><br>";
        MyIntl.VE_BUILDPROJECT_4 = "<font color=\"#FF9999\">N�o foi poss�vel carregar o arquivo-fonte</font> '$1 <font color=\"#FF9999\">em uma �rvore DOM.'</font>.<br>Pulando a intera��o: '$2'<br>";
        MyIntl.VE_BUILDPROJECT_5 = "<br><b>Mensagem do mecanismos de mapeamento de transforma��o de templates:</b><br><font color=\"#FF0000\"><b>N�o foi poss�evl executar a instru��o callTask:</b></font> '&lt;callTask id=\"$1\"/&gt;'<br>";
        MyIntl.VE_BUILDPROJECT_6 = "<font color=\"#FF0000\"><b>Erro da instru��o For-Each:</b></font> <br><br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Statement: </b>   &lt;for-each select=\"$1\"&gt;<br><br>N�o foi poss�vel selecionar o xpath.<br><br><b>Mensagem de erro:</b> $1 formato inv�lido.<br>";
        MyIntl.VE_BUILDPROJECT_7 = "<b><font color=\"#FF9900\">Aviso da instru��o For-Each:</font></b> <br><br>&nbsp;&nbsp;<b>Instru��o:</b> &lt;for-each select=\"$1\"&gt; no arquivo: $2<br><br>&nbsp;&nbsp;&nbsp;&nbsp;<b>Mensagem:</b> O seletor do Xpath n�o retornou nenhum n�.<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Action:</b> Instru��o ignorada.";
        MyIntl.VE_BUILDPROJECT_8 = "# Foram encontrados avisos na gera��o de templates.<br>Olhe a view de avisos para maiores detalhes.<br>";
        MyIntl.VE_BUILDPROJECT_9 = "<font color=\"#FF9900\"><b>Erro da instru��o If: </b></font> <br><br>&nbsp;&nbsp;<b>Instru��o:</b> &lt;if test=\"$1\"&gt;<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>Mensagem:</b>Foi foi poss�vel executar o teste desta instru��o.<br><br>$2<br><br>Verifique a sintaxe no arquivo de mapeamento de transforma��o de template: $3 e tente denovo.<br>";
        MyIntl.VE_BUILDPROJECT_10 = "N�o foi poss�vel executar a task: '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_11 = "N�o foi poss�vel achar a task id = '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_12 = "N�o foi poss�vel achar o template: '$1'.<br>Corrija este erro colocando um caminho v�lido na marca��o 'template' da tarefa com id = '$2'.<br>Voc� pode achar exemplos na documenta��o.<br>";
        MyIntl.VE_BUILDPROJECT_13 = "<br>N�o foi poss�vel executar a task com id = '$1'.<br>  Error de XPath: $2<br><br>     Solu��o: <br><br>         Corrija este erro colocando uma express�o v�lida na marca��o 'newFilename'.<br><br>         Voc� pode achar exemplos na documenta��o.<br>";
        MyIntl.VE_BUILDPROJECT_14 = "N�o � poss�vel criar o diret�rio de sa�da: '$1'.<br>";
        MyIntl.VE_BUILDPROJECT_15 = "N�o � poss�vel criar ou sobre-escrever o arquivo: '$1'. Ignorando arquivo...<br>";
        MyIntl.VE_BUILDPROJECT_16 = "N�o � poss�vel salvar o arquivo: '$1'. Ignorando...<br>";
        MyIntl.VE_BUILDPROJECT_17 = "N�o � poss�vel salvar o arquivo-fonte '$1'.<br><br>$2";
        
        MyIntl. VE_ANTRUNNER_1 = "<b><font color=\"#FF9966\">Ant iniciado...</font></b><br>";
        MyIntl. VE_ANTRUNNER_2 = "<b>Arquivo do Ant:</b> $1<br>";
        MyIntl. VE_ANTRUNNER_3 = "<br><b><font color=\"#FF0000\">Resultado da execu��o do Ant: erro.</font></b><br><br>$1";
        MyIntl. VE_ANTRUNNER_4 = "<br><font color=\"#009933\"><b>Resultado da execu��o do Ant: successo.</b></font><br><br>";
        MyIntl. VE_ANTRUNNER_5 = "<br><b><font color=\"#FF0000\">Resultado da execu��o do Ant: erro.</font></b><br>Mensagem do Ant: N�o foi poss�vel executar o alvo (\"target\") padr�o (\"default\").<br>";
        MyIntl. VE_ANTRUNNER_6 = "<font color=\"#FF0000\"><b>N�o foi poss�vel pr�-processar o arquivo do Ant:</b></font>$1<br><br>";
        MyIntl. VE_ANTRUNNER_7 = "<font color=\"#FF0000\"><b>N�o foi poss�vel pr�-processar o arquivo do Ant: </b></font>$1<br>";
        MyIntl. VE_ANTRUNNER_8 = "<font color=\"#FF0000\"><b>Permiss�o de escrita negada.</b></font><br>";

        MyIntl.VE_BUILDUTIL_1 = "<b>Gerando arquivo:</b> ";
        MyIntl.VE_BUILDUTIL_2 = "<b>Arquivo:</b> '$1' n�o existente.<br>$2";
        MyIntl.VE_BUILDUTIL_3 = "Exce��o: ";
        MyIntl.VE_BUILDUTIL_4 = "<b>Descri��o do erro:</b><br><br>";
        MyIntl.VE_BUILDUTIL_5 = "<br><b>Nome do erro:</b> ";
        MyIntl.VE_BUILDUTIL_6 = "<b>Descri��o da exce��o:</b><br><br>";
        MyIntl.VE_BUILDUTIL_7 = "<br><b>Aviso:</b> n�o � poss�vel criar o arquivo: $1";
        MyIntl.VE_BUILDUTIL_8 = "<font color=\"#FF0000\"><b>N�o � poss�vel transformar o item:</b></font><br><br>&nbsp;  <b>Arquivo-fonte :</b> $1.<br>&nbsp;  <b>Arquivo alvo:</b> $2.<br><b>Arquivo de template :</b> $3.<br><br>";
        MyIntl.VE_BUILDUTIL_9 = "N�o foi poss�vel rodar a safe-zone do arquivo-fonte: '$1' e do novo arquivo: '$2'<br><br>$3<br>";

        MyIntl.VE_FITBODY_CARD_1 = "Variante";
        MyIntl.VE_FITBODY_CARD_2 = "Formul�rio";
        
        MyIntl.VE_EXEC_FUNCTION_1 = "Instru��o 'If', O atributo de teste est� chamando a fun��o: $1<br>";
        MyIntl.VE_EXEC_FUNCTION_2 = "# Existem avisos na gera��o do template. Olhe a view de avisos para maiores detalhes.<br>";
        MyIntl.VE_EXEC_FUNCTION_3 = "N�o foi poss�vel recuperar a express�o XPath da string: $1.<br><br>$2";
        MyIntl.VE_EXEC_FUNCTION_4 = "# Existem avisos na gera��o do template. Olhe a view de avisos para maiores detalhes.<br>";
        MyIntl.VE_EXEC_FUNCTION_5 = "Aviso da instru��o 'If'.<br>N�o foi poss�vel recuperar a express�o XPath da string: \"$1\".<br><br><font color=\"#FF0000\"><b>Erro:</b></font><br><br>  $2.<br><br>Verifique a sintaxe desse XPath no arquivo de mapeamento de transforma��o de template.";

        MyIntl.VE_TAILOREXPATH_UTIL_1 = "N�o foi poss�vel avaliar a express�o XPATH: '$1'.<br>";

        MyIntl.VE_CLEAN_PROJECT_1 = "<br><b>O diret�rio: $1 foi apagado recursivamente.</b>";
        MyIntl.VE_SECOND_LAYER_VALIDATOR_1 = "<a href=\"$1\">$1</a><b><font color=\"#FF0000\">Erro de valida��o estrutural.</font></b><br><br><b>Caminho do erro: </b>$2<br><br><b>Mensagem do erro: </b><br><br>Este formul�rio requer pelo menos $3 formul�rios filhos com nome igual a: <b>$5</b><br>A configura��o corrente possuir apenas $4 formul�rios filho(s) com esse nome.<br><br><br>Insira os formul�rios requeridos para conseguir uma especifica��o v�lida.<br>";
        
        MyIntl.VE_VALIDATE_PROJECT_1 = "<font color=\"#FF0000\"><b>Erro de valida��o de formul�rio.</b></font><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_2 = "<b>Caminho do erro: </b><a href=\"$1\">$1</a><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_3 = "<b>Mensagem de erro: </b><br><br>";
        MyIntl.VE_VALIDATE_PROJECT_4 = "<font color=\"#0000FF\">$1</font><br>";

        MyIntl.VE_GENERAL_1 = "<br><b>Use a ferramenta de valida��o de meta-modelos para maiores detalhes.</b><br><br>";

        //-------------------------------------------------------------------------

        MyIntl.NCP_LABEL_ADD = "Adicionar";
        MyIntl.NCP_LABEL_REMOVE = "Remover";
        MyIntl.NCP_LABEL_EDIT = "Editar";
        MyIntl.NCP_LABEL_UP = "Acima";
        MyIntl.NCP_LABEL_DOWN = "Abaixo";
        MyIntl.NCP_LABEL_HELP = "Ajuda";
        MyIntl.NCP_LABEL_FE = "Elementos de formul�rio: ";
        MyIntl.NCP_LABEL_FECHOOSER = "Selecione o elemento de formul�rio";
        MyIntl.NCP_LABEL_NAME = "nome";
        MyIntl.NCP_LABEL_VALUE = "valor";
        MyIntl.NCP_LABEL_PARAMETERS = "Par�metros: ";
        MyIntl.NCP_LABEL_ELEMENT = "Elemento:";
        MyIntl.NCP_LABEL_TEST = "Teste";
        MyIntl.NCP_LABEL_OK = "Ok";
        MyIntl.NCP_LABEL_CANCEL = "Cancelar";
        MyIntl.NCP_LABEL_FE2 = "Elemento de formul�rio";
        MyIntl.NCP_LABEL_NAME2 = "Nome: ";
        MyIntl.NCP_LABEL_VALUE2 = "Valor: ";
        MyIntl.NCP_LABEL_PAR_DESC = "Descri��o dos par�metros";
        MyIntl.NCP_LABEL_SHOW_PAR1 = "<p><b>Este elemento possui esses par�metros:</b></p><br>";
        
        MyIntl.NCP_LABEL_SHOW_PAR2 = "<b>Nome do par�metro:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR3 = "<b>&nbsp;&nbsp;Tipo do par�metro:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR4 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Valor padr�o:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR5 = "<b>Express�o regular:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR6 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Requerido:</b> ";
        MyIntl.NCP_LABEL_SHOW_PAR7 = "<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Descri��o curta:</b> ";
        
        MyIntl.NCP_LABEL_MIN_CHILDS = "M�nimo de filhos: ";
        MyIntl.NCP_LABEL_MAX_CHILDS = "M�ximo de filhos: ";
        MyIntl.NCP_LABEL_NEXTFORMS = "Pr�ximos formul�rios: ";
        MyIntl.NCP_LABEL_NF_ERROR1 = "Este elemento requer o par�metro 'id'.\n";

        MyIntl.NCP_LABEL_PL1 = "Lista de par�metros: ";

        //-------------------------------------------------------------------------

        MyIntl.MSG1 = "Por favor, crie ou abra um projeto antes de usar o painel de navega��o.";
        MyIntl.MSG2 = "Um erro ocorreu na gera��o do template.\nOlha a view de erro para maiores detalhes.\n\n";
        MyIntl.MSG3 = "N�o h� nenhum projeto aberto.";
        MyIntl.MSG4 = "O projeto n�o est� salvo.\nSalve o projeto primeiro.";
        MyIntl.MSG5 = "O arquivo $1 n�o foi achado.";
        MyIntl.MSG6 = "N�o � poss�vel gerar o projeto.\n\nO diret�rio de template: '$1' n�o existe.";
        MyIntl.MSG7 = "N�o � poss�vel gerar o projeto.\nO diret�rio de template: '$1' n�o � um diret�rio.";
        MyIntl.MSG8 = "N�o � poss�vel gerar o projeto.\n\nO diret�rio de sa�da: '$1' n�o existe.";
        MyIntl.MSG9 = "N�o � poss�vel gerar o projeto.\n\nO diret�rio de sa�da: '$1' n�o � um diret�rio.";
        MyIntl.MSG10 = "N�o � poss�vel gerar o projeto.\n\nN�o � poss�vel escrever no diret�rio: '$1'.\nPermiss�o negada.";
        MyIntl.MSG11 = "N�o � poss�vel gerar o projeto.\n\nFormato inv�lido do arquivo de sa�da: '$1'.";
        MyIntl.MSG12 = "N�o � poss�vel gerar o projeto.\n\nO arquivo de mapeamento: '$1' n�o pode ser recuperado.";
        MyIntl.MSG13 = "Foram achados erros na gera��o dos templates!\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG14 = "N�o � poss�vel gerar o projeto.\n\nO caminho: '$1' n�o existe.";
        MyIntl.MSG15 = "N�o � poss�vel gerar o projeto.\n\nO caminho: '$1' n�o � um diret�rio.";
        MyIntl.MSG16 = "N�o foi poss�vel carregar o arquivo de mapeamento: ";
        MyIntl.MSG17 = "Erro na gera��o.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG18 = "N�o foi poss�vel carregar o arquivo-fonte.\n";
        MyIntl.MSG19 = "N�o existe nenhum projeto aberto para ser limpo.";
        MyIntl.MSG20 = "N�o foi poss�vel limpar o projeto.\nO diret�rio de sa�da: $1 n�o existe.";
        MyIntl.MSG21 = "N�o foi poss�vel limpar o projeto.\nO diret�rio de sa�da: $1 n�o � um diret�rio.";
        MyIntl.MSG22 = "N�o foi poss�vel limpar o projeto.\n\nO diret�rio de sa�da: $1 n�o pode ser apagado.";
        MyIntl.MSG23 = "Arquivos removidos.\nOlhe a view de console para maiores detalhes.";
        MyIntl.MSG24 = "N�o h� arquivos do projeto para serem removidos.";
        MyIntl.MSG25 = "N�o h� nenhum projeto aberto pelo gerenciador de projeto.";
        MyIntl.MSG26 = "N�o h� nenhum projeto aberto pelo gerenciador de projeto.";
        MyIntl.MSG27 = "O projeto corrente n�o est� salvo.\nDevemos salvar o projeto antes de fecha-lo?";
        MyIntl.MSG28 = "Fechar projeto.";
        MyIntl.MSG29 = "Projecto $1 fechado.";
        MyIntl.MSG30 = "Arquivo do projeto n�o encontrado.";
        MyIntl.MSG31 = "N�o foi poss�vel carregar o projeto.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG32 = "N�o h� nenhum projeto aberto para gerar.";
        MyIntl.MSG33 = "O projeto n�o est� salvo.\nPara gerar o projeto � necess�rio salvas-lo primeiro.\nVoc� quer salvar o projeto?";
        MyIntl.MSG34 = "Gerar projeto.";
        MyIntl.MSG35 = "Valida��o executada com sucesso";
        MyIntl.MSG36 = "N�o h� nenhum projeto aberto pelo gerenciador de projetos.";
        MyIntl.MSG37 = "N�o h� nenhum projeto aberto para salvar.";
        MyIntl.MSG38 = "O projeto ja est� salvo.";
        MyIntl.MSG39 = "Erro de valida��o.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG40 = "N�o foi poss�vel salvar o projeto.\nO arquivo: $1 n�o existe.";
        MyIntl.MSG41 = "N�o foi poss�vel salvar o projeto.\nExce��o de entrada e sa�da durante a limpeza do arquivo de sa�da.\n$1";
        MyIntl.MSG42 = "N�o foi poss�vel salvar o projeto.\nMensagem: \n\n    $1";
        MyIntl.MSG43 = "N�o h� nenhum projeto aberto para salvar como.";
        MyIntl.MSG44 = "O diret�rio $1 ja existe.\nEssa ferramenta n�o vai sobre-escrever o conte�do desse diret�rio que cont�m os arquivos do projeto.\nPor favor escolha outro diret�rio ou primeiro remova o diret�rio $1 para outro lugar.";
        MyIntl.MSG45 = "O projeto corrente n�o est� salvo. Voc� deseja salvar o projeto antes?";
        MyIntl.MSG46 = "Salvar Como";
        MyIntl.MSG47 = "A��o cancelada.";
        MyIntl.MSG48 = "Erro.\nN�o foi poss�vel criar o diret�rio: $1";
        MyIntl.MSG49 = "Erro.\nN�o foi poss�vel abrir: $1";
        MyIntl.MSG50 = "Erro.\nN�o foi poss�vel copiar o diret�rio $1 para o diret�rio $2.";
        MyIntl.MSG51 = "Erro.\nN�o foi poss�vel criar: $1";
        MyIntl.MSG52 = "Erro.\nN�o foi poss�vel criar o diret�rio: $1";
        MyIntl.MSG53 = "Projeto criado.\nVoc� quer abrir o novo projeto?";
        MyIntl.MSG54 = "N�o h� nenhum projeto aberto para validar.";
        MyIntl.MSG55 = "Erro de valida��o.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG56 = "Erro de valida��o.\nOlhe a view de erros para maiores detalhes.";
        MyIntl.MSG57 = "Projeto salvo.";
        MyIntl.MSG58 = "N�o � poss�vel instanciar a classe: $1";
        MyIntl.MSG59 = "         Erro - Existem par�metros obrigat�rios faltando.\nCorre��o - Coloque os par�metros obrigat�rios na lista.\n\n           Tip -  Olhe a documenta��o individual de cada elementos para maiores detalhes.\n";
        MyIntl.MSG60 = "Erro.\nO campo 'id' n�o cont�m nenhum valor.";
        MyIntl.MSG61 = "O campo id n�o est� no formato da express�o regular: $1.";
        MyIntl.MSG62 = "O valor do campo 'min childs' deve ser um n�mero.";
        MyIntl.MSG63 = "O valor do campo 'min childs' deve ser um n�mero.";
        MyIntl.MSG64 = "o valor do campo 'max childs' deve ser um valor maior do que '1' ou a string 'N'.";
        MyIntl.MSG65 = "o valor do campo 'max childs' value deve ser um n�mero ou a string 'N'.";
        MyIntl.MSG66 = "O painel de id n�o pode ficar em branco.";
        MyIntl.MSG67 = "A lista do require precisa de pelo menos 1 item.";
        MyIntl.MSG68 = "Esse caminho ja existe na lista de caminhos.";
        MyIntl.MSG69 = "A coluna $1 est� em branco.";
        MyIntl.MSG70 = "HelpSet n�o encontrado.";
        MyIntl.MSG71 = "Erro";
        MyIntl.MSG72 = "N�o foi poss�vel criar o HelpSet para o $1.";
        MyIntl.MSG73 = "N�o foi poss�vel criar uma URL para o $1.";
        MyIntl.MSG74 = "N�o � poss�vel apagar o formul�rio ra�z: $1.";
        MyIntl.MSG75 = "Voc� tem certeza que quer apagar o formul�rio: \"$1\"?";
        MyIntl.MSG76 = "Apagar formul�rio.";
        MyIntl.MSG77 = "Esse n� pode ter apenas $1 $2 filhos.";
        MyIntl.MSG78 = "N�o h� ajuda dispon�vel para este formul�rio.";
        MyIntl.MSG79 = "N�o � poss�vel apagar este formul�rio.\nO formul�rio pai ($1) requer pelo menos $2 \"$3\" filhos.";
        MyIntl.MSG80 = "N�o h� nenhum projeto aberto para salvar como.";
        MyIntl.MSG81 = "Cria��o do projeto cancelada.";
        MyIntl.MSG82 = "N�o foi poss�vel achar o formul�rio: ";
        MyIntl.MSG83 = "A aplica��o n�o pode trabalhar apropriadamente porque voc� n�o tem permiss�o de escrita no diret�rio : $1.\nCorrija este problema e tente novamente.";
        MyIntl.MSG84 = "Valida��o do meta-modelo ok.";
        MyIntl.MSG85 = "Foi achado um erro no meta-modelo. Olhe a janela do MMV para maiores detalhes.";
        MyIntl.MSG86 = "O nome do projeto cont�m um caracter inv�lido.";
        MyIntl.MSG87 = "Nome do projeto inv�lido.\nA primeirA letra deve ser mai�scula.";
        MyIntl.MSG88 = "Nome do projeto inv�lido.\nEla n�o est� no formato da express�o regular: $1";
        MyIntl.MSG89 = "Por favor, selecione um dom�nio antes de pressionar 'Next'.";
        MyIntl.MSG90 = "Gera��o completa!";
        MyIntl.MSG91 = "Gera��o cancelada.";
        
        //NCPMessages
        MyIntl.MSG92 = "Voc� tem certeza que quer remover este item?";
        MyIntl.MSG93 = "Remover elemento de formul�rio";
        MyIntl.MSG94 = "Voc� solicitou uma mudan�a na lista de elementos.\nVoc� gostaria de remover todos os par�metros da lista de par�metros e carregar os par�metros obrigat�rios do novo elemento na lista de par�metros?";
        MyIntl.MSG95 = "Mudar elemento";
        MyIntl.MSG96 = "Selecione uma linha primeiro.";
        MyIntl.MSG97 = "Selecione um elemento na caixa de sele��o para ser testado.";
        MyIntl.MSG98 = "Por favor, selecione um elemento de formul�rio na caixa de sele��o antes de pressionar o bot�o 'Ok'";
        MyIntl.MSG99 = "A lista de par�metros cont�m alguns par�metros que n�o s�o utilizados pelo elemento de formul�rio selecionado.\nEsse par�metros ser�o ignorados pela ferramenta em tempo de execu��o.\n\nOs par�metros que n�o ser�o utilizados s�o:\n\n";
        MyIntl.MSG100 = "\n\nVoc� quer continuar?";
        MyIntl.MSG101 = "Par�metros n�o utilizados detectados";
        MyIntl.MSG102 = "N�o � poss�vel remover o par�metro.\nO par�metro que voc� est� tentando remover � tem uso obrigat�rio no elemento de formul�rio selecionado.";
        MyIntl.MSG103 = "O nome n�o pode estar em branco.";
        MyIntl.MSG104 = "O valor n�o pode estar em branco.";
        MyIntl.MSG105 = "N�o � poss�vel criar a inst�ncia do elemento.\n\n";
        MyIntl.MSG106 = "N�o � poss�vel criar a inst�ncia do elemento: $1.\n\n$2";
        MyIntl.MSG107 = "O valor do campo 'Max Childs' deve ser maior ou igual ao valor do campo 'Min Childs'.";
        MyIntl.MSG108 = "Voc� selecionou uma auto-rela��o de elemento (o pr�ximo formul�rio desse elemento aponta para ele mesmo).\nVoc� n�o pode selecionar um valor para o campo 'min childs' diferente de '0'.";
        MyIntl.MSG109 = "A lista dos pr�ximos formul�rios ja cont�m o n� selecionado ('New Form').";
        MyIntl.MSG110 = "Voc� tem certeza que quer remover esse item?";
        MyIntl.MSG111 = "Remover o pr�ximo formul�rio";
        MyIntl.MSG112 = "Voc� deve selecionar um n� \"New Form\" na �rvore de formul�rios.";
        MyIntl.MSG114 = "Por favor, selecione um elemento de formul�rio na caixa de sele��o antes de adicionar um par�metro.";
        MyIntl.MSG115 = "N�o foi poss�vel achar o pr�ximo elemento.";

        //-------------------------------------------------------------------------
    
    }

}
