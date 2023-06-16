package req;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Luces
 * @param <E>
 */
public class ReqMsg <E>implements Serializable {
    private Object reqmsg;
    private String msgcode;
/*----------------------------------------------------------------------------*/
    // Constructores
    
    
    public ReqMsg(E reqmsg, String msgcode) {
        this.reqmsg = (Object)reqmsg;
        this.msgcode = msgcode;
    }

/*----------------------------------------------------------------------------*/
    //Metodos set/ Get

    public Object getReqmsg() {
        return reqmsg;
    }

    public void setReqmsg(E reqmsg) {
        this.reqmsg = reqmsg;
    }

    public String getMsgcode() {
        return msgcode;
    }

    public void setMsgcode(String msgcode) {
        this.msgcode = msgcode;
    }
    
/*----------------------------------------------------------------------------*/
    //Metodos
    
    
    
}
