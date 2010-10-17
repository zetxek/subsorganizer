package subsorganizer.tools;

import java.io.File;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextArea;

/**
 *
 * @author zetxek
 */
public class subsrenamer {

    public static void readFiles(File folder, boolean recursive, JTextArea output) {
        File[] files = folder.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {

                //subtitulo. existe avi que tengamos que copiar??
                if (files[i].getName().contains(".srt")) {
                    String aviStr = files[i].getName().replace(".srt", ".avi");
                    aviStr = files[i].getParent() + File.separator + aviStr;
                    File aviFile = new File(aviStr);

                    if (!aviFile.exists()) {
                        //File aviFile2 = new File(aviStr.replace(".es", ""));
                        //System.out.println("NO Existe " + aviFile.getAbsolutePath() + "??");
                        output.append("\nLooking for video file for " + files[i].getName() + "...");
                        //se obtiene nombre nuevo
                        File newSrt = getNewName(files[i]);
                        //existe nombre nuevo
                        if (newSrt != null) {
                            //no existe ya
                            if (!newSrt.exists()) {
                                //System.err.println("obtenido: " + newSrt.getAbsolutePath());
                                //files[i].renameTo(newSrt);

                                boolean success = files[i].renameTo(newSrt);
                                if (!success) {
                                    output.append("Error renaming \"" + files[i].getAbsolutePath() + "\" to \"" + newSrt.getAbsolutePath() + "\"\n");
                                } else {
                                    output.append("Moved: \""
                                            + files[i].getAbsolutePath() + "\" to \""
                                            + newSrt.getAbsolutePath() + "\"\n");
                                }

                            } else {
                                output.append("File \"" + newSrt.getAbsolutePath() + "\" already exists!\n");
                            }
                        }

                    }
                }

            } else if (files[i].isDirectory()) {
                //System.out.println("Directory " + files[i].getName());
                if (recursive)
                    readFiles(files[i], true, output);
            }
        }
    }

    public static File getNewName(File file) {
        File result = null;
        try {
            //s01e01
            Pattern pEngFormat = Pattern.compile("[sS]?\\d?\\d(.)?\\d?\\d",
                    Pattern.CASE_INSENSITIVE);

            Matcher m = pEngFormat.matcher(file.getName());
            String chapter = "";
            if (m.find()) {
                chapter = m.group();
            }

            //1x01
            Pattern pSpaFormat = Pattern.compile("\\d?\\d(x)\\d?\\d",
                    Pattern.CASE_INSENSITIVE);

            Matcher mSpa = pSpaFormat.matcher(file.getName());
            chapter = "";
            if (mSpa.find()) {

                NumberFormat nf = NumberFormat.getInstance();
                nf.setMinimumIntegerDigits(2);
                nf.setMaximumIntegerDigits(2);
                
                chapter = mSpa.group();
                chapter = chapter.replace("x", "X");

                String season = chapter.substring(0, chapter.indexOf("X"));
                Integer seasonInt = Integer.parseInt(season);
                season = nf.format(seasonInt);

                String chapt = chapter.substring(chapter.indexOf("X") + 1, chapter.length() );

                Integer chapterInt = Integer.parseInt(chapt);
                chapt = nf.format(chapterInt);

                chapter = "S" + season + "E" + chapt;
            }

            if (chapter.isEmpty()) {
                return null;
            }

            //System.out.println("Buscando " + chapter);

            File parentFolder = file.getParentFile();
            File[] files = parentFolder.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().contains(".avi")
                        && files[i].getName().contains(chapter)) {
                    //se obtiene el AVI con extension SRT
                    //System.err.println("DEVOLVIENDO " + files[i].getAbsolutePath());
                    result = new File(files[i].getAbsolutePath().replace(".avi", ".srt"));
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}
