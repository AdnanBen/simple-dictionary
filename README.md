# simple-dictionary

A simple file based dictionary. Based on Helsinki Java MOOC exercise part 11_13.

## Usage

To create a new dictionary

```java
SaveableDictionary dictionary = new SaveableDictionary();
```

To manually add translations

```java
dictionary.add("apina", "monkey");
dictionary.add("banaani", "banana");
dictionary.add("apina", "apfe");
```

To translate a word

```java
dictionary.translate("apina");
dictionary.translate("monkey");
```

To delete words from dictionary

```java
dictionary.delete("apina");
dictionary.delete("banana");
```

To load translations from a file

```java
SaveableDictionary dictionary = new SaveableDictionary("words.txt");
dictionary.load();
```

Format within file should be:  
\<word\>:\<word\>\n

To save dictionary changes to file

```java
dictionary.save();
```

## To do

- Improve UI, flexibility in loading/saving
- Add GUI
- Add SQL support

## License
[MIT](https://choosealicense.com/licenses/mit/)
