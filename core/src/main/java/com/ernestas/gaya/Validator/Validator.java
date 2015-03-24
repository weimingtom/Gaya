package com.ernestas.gaya.Validator;

import com.ernestas.gaya.Exceptions.FileHandlingException;
import com.ernestas.gaya.Exceptions.GayaException;
import com.ernestas.gaya.Exceptions.InvalidFileException;
import com.google.common.base.Joiner;

import java.io.*;
import java.util.*;

public class Validator {

    private final String SCOPE_SCENARIO = "scenario";
    private final String SCOPE_ENEMY = "enemy";
    private final String SCOPE_WAVE = "wave";

    private String path;

    private String[] scenario = new String[] {
        "NAME string", "ENEMY class", "WAVE class"
    };

    private String[] enemy  = new String[]{
        "NAME string", "HEALTH integer", "SPEED integer", "AI string"
    };

    private String[] wave = new String[] {
        "ID int", "OFFSET expression", "SPAWN *"
    };

    private String[] bindings = new String[] {
        "SCREEN_WIDTH", "SCREEN_HEIGHT", ""
    };

    private ArrayList<String> customBindings = new ArrayList<String>();

    private Stack<String> scope = new Stack();

    public Validator(String path) {
        this.path = path;
        scope.push("scenario");
    }

    public boolean isValid() {
        try {
            fileToString();
            return true;
        } catch (GayaException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String fileToString() throws GayaException {
        File file = new File(path);
        BufferedReader reader;
        try {
            FileReader fr = new FileReader(file);
            reader = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw new InvalidFileException("File not found.");
        }

        if (!file.isFile()) {
            throw new InvalidFileException("File is actually not a file.");
        }

        if (!file.canRead()) {
            throw new InvalidFileException("Could not read file. Check file permissions.");
        }

        List<String> lines = new LinkedList<String>();
        try {
            String line;
            while((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch (IOException e) {
            throw new FileHandlingException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new FileHandlingException(e);
            }
        }

        return Joiner.on("").skipNulls().join(lines);
    }

}
