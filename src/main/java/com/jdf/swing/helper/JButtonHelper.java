package com.jdf.swing.helper;

import com.jdf.swing.iface.IconPackBase64;
import com.jdf.swing.iface.ImageReaderBase64;
import com.jdf.util.Caracteres;
import com.jdf.util.UtilMethod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Classe auxiliar para objetos JButton
 *
 * @author lossurdo
 * @since 01/03/2009
 */
public class JButtonHelper implements IconSets {

    private JButton button;
    private Date date;
    private static final DateChooser dateChooser = new DateChooser((JFrame) null);
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
            "dd/MM/yyyy");
    private static final DateFormat TIME_FORMAT = new SimpleDateFormat(
            "HH:mm");
    private static final TimeChooser timeChooser = new TimeChooser(null);

    /**
     * Construtor
     *
     * @param btn
     */
    public JButtonHelper(JButton btn) {
        this.button = btn;
    }

    /**
     * Transforma um botÃ£o em campo hora utilizando a data atual
     */
    public void transformToTimeButton() {
        transformToTimeButton(Calendar.getInstance().getTime());
    }

    /**
     * Transforma um botÃ£o em campo hora
     *
     * @param time Hora
     */
    public void transformToTimeButton(Date time) {
        button.setIcon(new ImageReaderBase64(IconPackBase64.TIME).toImage());
        button.setFocusable(false);
        button.setText(extractTimeFromDate(time));
        this.date = time;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                fireTimeChooser(JButtonHelper.this.date);
            }
        });
    }

    /**
     * Chama o TimeChooser e disponibiliza a hora escolhida
     *
     * @param date
     */
    private void fireTimeChooser(Date date) {
        Date newDate = timeChooser.select(date);
        if (newDate == null) {
            return;
        }
        button.setText(extractTimeFromDate(newDate));
        this.date = newDate;
    }

    /**
     * Transforma um botÃ£o em campo data (calendÃ¡rio) utilizando a data atual
     */
    public void transformToDateButton() {
        transformToDateButton(Calendar.getInstance().getTime());
    }

    /**
     * Transforma um botÃ£o em campo data (calendÃ¡rio)
     *
     * @param date Data inicial do campo
     */
    public void transformToDateButton(Date date) {
        button.setIcon(new ImageReaderBase64(IconPackBase64.CALENDAR).toImage());
        button.setFocusable(false);
        button.setText(DATE_FORMAT.format(date));
        this.date = date;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                fireDateChooser(JButtonHelper.this.date);
            }
        });
    }

    /**
     * Chama o DateChooser e disponibiliza a data escolhida
     *
     * @param date
     */
    private void fireDateChooser(final Date date) {
        Date newDate = dateChooser.select(date);
        if (newDate == null) {
            return;
        }
        button.setText(DATE_FORMAT.format(newDate));
        this.date = newDate;
    }

    /**
     * Seta o valor da data
     *
     * @param date Novo valor da data
     * @return Antigo valor da data
     *
     */
    public void setDate(Date date) {
        this.date = date;
        button.setText(DATE_FORMAT.format(date));
    }

    public void setTime(Date date) {
        this.date = date;
        button.setText(TIME_FORMAT.format(date));
    }

    /**
     * Retorna o valor da data
     *
     * @return Data
     *
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Transforma botÃ£o em um "chamador" de LOV
     *
     * @param object Objeto que contÃ©m a aÃ§Ã£o/mÃ©todo a ser executado
     * @param action AÃ§Ã£o a ser executada
     */
    public void transformToLOV(final Object object, final String action) {
        button.setText("");
        button.setToolTipText("Lista de Valores");
        setIcon(IconPackBase64.APPLICATION_VIEW_LIST);
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                UtilMethod.executeMethod(object, action);
            }
        });
    }

    /**
     * Insere um Ã­cone em um botÃ£o
     *
     * @param icon Enum com referÃªncia ao Ã­cone
     */
    public void setIcon(IconPackBase64 icon) {
        button.setIcon(new ImageReaderBase64(icon).toImage());
    }

    /**
     * Insere um Ã­cone em um botÃ£o
     *
     * @param icon ReferÃªncia ao arquivo
     */
    public void setIcon(String icon) {
        button.setIcon(new ImageReaderBase64(icon).toImage());
    }

    /**
     * Adiciona uma aÃ§Ã£o ao evento de clique no botÃ£o
     *
     * @param object Objeto que contÃ©m a aÃ§Ã£o a ser executada
     * @param method MÃ©todo a ser executado
     */
    public void addAction(final Object object, final String method) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                UtilMethod.executeMethod(object, method);
            }
        });
    }

    private String extractTimeFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String h = Caracteres.strzero(cal.get(Calendar.HOUR_OF_DAY));
        String m = Caracteres.strzero(cal.get(Calendar.MINUTE));
        return h + ":" + m;
    }

    @Override
    public void setIcon(ImageIcon icon) {
    }

    public static final Date toDateTime(JButtonHelper buttonHelperDate, JButtonHelper buttonHelperTime) throws ParseException {
        Date d = buttonHelperDate.getDate();
        Date h = buttonHelperTime.getDate();
        String dd = new SimpleDateFormat("dd/MM/yyyy").format(d);
        String hh = new SimpleDateFormat("HH:mm:ss").format(h);
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dd + " " + hh);
    }
}
