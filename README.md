underline
=========

_underline_ is a command-line parser for Java. It allows for creating
command-line programs with a Git-like interface. It is lightweight and
has no dependencies to external libraries (*&ldquo;no strings attached&rdquo;*).
_underline_ supports Java 1.6 and higher.

The library is really low-level but
extremely flexible. There are a number of alternatives (such as
[JCommander](http://jcommander.org/) or
[Apache Commons CLI](http://commons.apache.org/proper/commons-cli/)) but
_underline_ enables you to fully control how your command-line arguments are
parsed and handled. If you're stuck with one of the existing libraries and
need more flexibility then _underline_ may be the right tool for you.

Download
--------

Download is not available yet. Please refer to the `Building` section below.

Usage
-----

1. Specify options using annotations.

    ```java
    @OptionDesc(longName = "help", shortName = "h",
        description = "display this help and exit")
    public void setDisplayHelp(boolean displayHelp) {
      this.displayHelp = displayHelp;
    }
    ```

2. Specify command and sub-commands using annotations.

    ```java
    @CommandDescList({
        @CommandDesc(longName = "subcommand",
            description = "my sub-command",
            command = MySubCommand.class),
        @CommandDesc(longName = "othercmd",
            description = "another command",
            command = MyOtherCommand.class)
    })
    public void setCommand(Command command) {
      this.command = command;
    }
    ```

3. Use `OptionIntrospector` to inspect your classes and generate a model for all
   specified command line options.

    ```java
     OptionGroup<ID> options = OptionIntrospector.introspect(this.getClass());
    ```

4. `OptionParser` parses command-line arguments according to the model
   created by the introspector.

    ```java
    OptionParser.Result<ID> parsedOptions = OptionParser.parse(args,
        options, OptionIntrospector.DEFAULT_ID);
    ```

5. Use `OptionIntrospector` to inject the parsed results into your class.

    ```java
    OptionIntrospector.evaluate(parsedOptions.getValues(), this);
    ```

6. Display usage information.

    ```java
    String unknownArg = OptionIntrospector.getUnknownArgumentName(this.getClass());
    OptionParser.usage("mycommand", "My own command", options,
        unknownArg, new PrintWriter(System.out, true));
    ```

This will output:

    Usage: mycommand [OPTION]... [COMMAND]
    My own command

      -h,--help   display this help and exit

    Commands:
      subcommand  my sub-command
      othercmd    another command

Real-world example
------------------

[citeproc-java](http://michel-kraemer.github.io/citeproc-java/) uses _underline_
for its [command-line interface](http://michel-kraemer.github.io/citeproc-java/using/command-line-tool/).
This is a very complex example that demonstrates how flexible _underline_ is.

Building
--------

Execute the following command to compile the library and to run the
unit tests:

    ./gradlew test

The script automatically downloads the correct Gradle version, so you
won't have to do anything else. If everything runs successfully, you
may create a .jar library:

    ./gradlew jar

The library will be located under the `build/libs` directory.

License
-------

_underline_ is licensed under the
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
