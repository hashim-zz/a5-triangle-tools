package triangle;

import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.Arguments;

/**
 * This class defines command-line options for the Triangle compiler.
 * It uses the Airline CLI parser library to parse the input arguments.
 */
@Command(name = "triangle-compiler", description = "Compiles Triangle source code into TAM object code.")
public class Options {

    @Arguments(
            title = "source",
            description = "The Triangle source file to compile"
    )
    public java.util.List<String> sourceFiles;

    /**
     * Output filename for compiled TAM code.
     * Usage: --objectName obj.tam
     */
    @Option(name = "--objectName", description = "The name of the output object file.")
    public String objectName = "obj.tam"; // default output file

    /**
     * Display AST after contextual analysis.
     * Usage: --showTree
     */
    @Option(name = "--showTree", description = "Show the AST after contextual analysis.")
    public boolean showTree = false;

    /**
     * Enable constant folding optimisation.
     * Usage: --folding
     */
    @Option(name = "--folding", description = "Enable constant folding.")
    public boolean folding = false;
}