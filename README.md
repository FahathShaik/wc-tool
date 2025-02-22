

# **ccwc - A Word Count CLI Tool**  

This is a Java implementation of the **wc** command-line utility, developed as a solution to the [wc coding challenge](https://codingchallenges.fyi/challenges/challenge-wc).  

## **Features**  
✅ Supports counting:  
- **Bytes (`-c`)**  
- **Lines (`-l`)**  
- **Words (`-w`)**  
- **Characters (`-m`)** (Handles multibyte characters based on locale)  
- **Default mode** (counts lines, words, and bytes if no flag is provided)  
- **Reads from both file input and standard input (stdin)**  
- **Can be used globally with an alias**  

---

## **Usage**  

### **Step 1: Count Bytes (`-c`)**  
```bash
ccwc -c test.txt
```
Example Output:
```
  342190 test.txt
```

---

### **Step 2: Count Lines (`-l`)**  
```bash
ccwc -l test.txt
```
Example Output:
```
    7145 test.txt
```

---

### **Step 3: Count Words (`-w`)**  
```bash
ccwc -w test.txt
```
Example Output:
```
   58164 test.txt
```

---

### **Step 4: Count Characters (`-m`)**  
```bash
ccwc -m test.txt
```
Example Output (depends on locale):
```
  339292 test.txt
```

---

### **Step 5: Default Mode (Counts Lines, Words, and Bytes)**  
```bash
ccwc test.txt
```
Example Output:
```
    7145   58164  342190 test.txt
```

---

### **Step 6: Read from Standard Input (Stdin Support)**  
If no filename is specified, `ccwc` reads input from stdin.  

```bash
cat test.txt | ccwc -l
```
Example Output:
```
    7145
```

---

## **Global Usage with an Alias**  

To use `ccwc` globally from anywhere in your terminal, create an **alias**:  

### **1. Compile the Java Program**  
```bash
javac ccwc.java
```

### **2. Set Up an Alias for Global Use**  
Add the following line to your `~/.bashrc`, `~/.bash_profile`, or `~/.zshrc` (depending on your shell):  

```bash
alias ccwc='java Main.java'
```
Replace `/path/to/your/compiled/class` with the actual path where your `ccwc.class` file is located.  

### **3. Reload Your Shell**  
```bash
source ~/.bashrc   # or ~/.zshrc for Zsh users
```

### **4. Use `ccwc` Anywhere**  
Now you can run `ccwc` from any directory:  

```bash
ccwc -w sample.txt
```

---

## **Future Enhancements**  
🔹 Support for multiple files in a single command.  
🔹 Improve performance for large files.  
🔹 Implement additional wc-like options for advanced text processing.  

---

## **License**  
This project is open-source and free to use.  
