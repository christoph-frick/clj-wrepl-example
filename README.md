# Example setup for [clj-wrepl](https://github.com/christoph-frick/clj-wrepl)

**Note:** Right now the deps are on no public repo.  So you need to install them locally.

This project combines `clj-wrepl` and some "plugins" into a configurable standalone REPL.

## Build

Build an *uberjar*

```shell
lein uberjar
```

## Run

```shell
% alias clj="java -jar target/uberjar/clj-0.1.0-SNAPSHOT-standalone.jar"
% clj --help
WREPL

wrepl [options...]

  -c, --config config.edn  Read the integrant system config from this file and merge it with the default
      --no-user-config     Don't load the default user config from $HOME/.wrepl.edn
  -i, --init script.clj    Run the given file before the first prompt
  -e, --eval string        Evaluate the expression (after --init if both given)
  -h, --help
```

A default config can be provided via `~/.wrepl.edn`.  Which should contain
things, you always want to use.  E.g. configure a printer and a color scheme:

```clojure
{:wrepl/print #ig/ref :wrepl.puget/print
 :wrepl.puget/print {:seq-limit 20 
                     :color-scheme {:delimiter [:red]
                                    :string nil
                                    :character nil
                                    :keyword [:yellow]
                                    :symbol [:magenta]
                                    :function-symbol [:bold :magenta]
                                    :class-delimiter [:magenta]
                                    :class-name [:bold :magenta]}}}
```

For more specific REPLs provide additional setup.  E.g. create a config file
`specter.edn` with additional overrides:

```clojure
{[:wrepl/append-init :wrepl/init] [#ig/ref :wrepl.specter/pomegranate
                                   #ig/ref :wrepl.specter/use-specter]
 [:wrepl.specter/pomegranate :wrepl.pomegranate/init] {:coordinates [[com.rpl/specter "1.0.3"]]}
 [:wrepl.specter/use-specter :wrepl.init/eval] {:expr "(use 'com.rpl.specter)"}}
```

And run it via the `clj` alias:

```shell
% clj -c specter.edn 
; (use (quote com.rpl.specter))
nil
user=> (transform [MAP-VALS even?] inc {:a 1 :b 2})
{:a 1, :b 3}
user=> 
```
