##
## EPITECH PROJECT, 2020
## makefile exe
## File description:
## fct
##

PACKAGE = 110/src/re/fazan/borwein

SRC = $(PACKAGE)/Main.java		\
	$(PACKAGE)/Maths.java

CLASSDIR = class

METAINF = META-INF/MANIFEST.MF

JARNAME	= 110borwein.jar 

EXENAME	= exec.sh

NAME = 110borwein

all: buildjar $(NAME)

buildjar:
	mkdir $(CLASSDIR)
	javac -d $(CLASSDIR) $(SRC)
	jar cfm $(JARNAME) $(METAINF) -C $(CLASSDIR) re

$(NAME):
	cp $(EXENAME) $(NAME)
	chmod +x $(NAME)

clean:
	rm -rf $(CLASSDIR)
	rm -f $(JARNAME)

fclean: clean
	rm -f $(NAME)

re:	fclean all
