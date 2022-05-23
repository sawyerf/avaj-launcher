NAME =		ajav_launcher

JC =		javac

SRC_DIR =	avaj

SRC_FILE =	Main.java                    \
			airport/Aircraft.java        \
			airport/AircraftFactory.java \
			flyable/Flyable.java         \
			flyable/Helicopter.java      \
			flyable/JetPlane.java        \
			flyable/Baloon.java          \
			weather/Tower.java           \
			weather/WeatherTower.java    \
			weather/WeatherProvider.java \
			weather/Coordinates.java

CLS_DIR  = .class
CLS_FILE = $(SRC_FILE:.java=.class)

JFLAGS =	

SRC = 		$(addprefix $(SRC_DIR)/,$(SRC_FILE))
CLS = 		$(addprefix $(CLS_DIR)/,$(CLS_FILE))
CLSS =		$(addprefix $(SRC_DIR)/,$(CLS_FILE))

all: $(NAME)

$(CLS_DIR)/%.class: $(SRC_DIR)/%.java
	@$(JC) -sourcepath $(SRC_DIR) -cp $(CLS_DIR) -d $(CLS_DIR) $<

$(NAME):
	find * -name "*.java" > sources.txt
	javac @sources.txt
	@printf "\033[0;32m[$(NAME)] Compilation [OK]\033[0;0m\n"


run: $(NAME)
	java avaj.Main scenario.txt

clean:
	@rm -rf $(CLS_DIR) $(CLSS)
	@printf "\033[0;31m[$(NAME)] Deleted *.class\033[0;0m\n"

fclean: clean
	@rm -rf simulation.txt sources.txt 2>&-

re: fclean all

.PHONY: all clean fclean re
