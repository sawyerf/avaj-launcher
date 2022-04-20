NAME =		ajav_launcher

JC =		javac

SRC_DIR =	src

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

all: $(NAME)

$(CLS_DIR)/%.class: $(SRC_DIR)/%.java
	@$(JC) -sourcepath $(SRC_DIR) -cp $(CLS_DIR) -d $(CLS_DIR) $<

$(NAME): $(CLS)
	@mkdir $(CLS_DIR) 2> /dev/null || true
	@printf "\033[0;32m[$(NAME)] Compilation [OK]\033[0;0m\n"

run: $(NAME)
	java -cp $(CLS_DIR) Main test.txt

clean:
	@rm -rf $(CLS)
	@printf "\033[0;31m[$(NAME)] Deleted *.class\033[0;0m\n"

fclean: clean

re: fclean all

.PHONY: all clean fclean re
