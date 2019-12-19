package com.wintech.datacenter.server;

import java.util.Timer;
import java.util.TimerTask;

import com.wintech.datacenter.degital.Translate;
import com.wintech.datacenter.send.AcceptDegitals;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
 
public class SocketHandler extends ChannelInboundHandlerAdapter {
	private String res;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("channel active>>>>>>>\n");
    }
 
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// public void schedule(TimerTask task, long delay, long period)
		// 这个方法是调度一个task，在delay（ms）后开始调度，每次调度完后，最少等待period（ms）后才开始调度。
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				byte[] bt = new AcceptDegitals().getBt();// 发送命令
				// String sendContent = "Response from server: \"" + new String(response) + "\""
				// ;
				ByteBuf seneMsg = Unpooled.buffer(bt.length);
				seneMsg.writeBytes(bt);
				ctx.writeAndFlush(seneMsg);
			}
		}, 0, 5000);

		ByteBuf message = (ByteBuf) msg;
		byte[] response = new byte[message.readableBytes()];
		message.readBytes(response);
		// System.out.println("<- " + new String(response) + "\n");


		// 响应结果
		res = new String(response);// ~2001470050FC000C4E48B4A39E0C4E48B4A39E0C4E48B4A39E0C4E48B4A39E0C4E48B4A39E0C4E48B4A39E5F5394E6470194E60194E60194E60194E60194E60194E601A6B001A6B001A6B001A6B001A6B001A6B07D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D147D14C5FB
		System.out.println(res);
		String flag = Translate.transDegital(res);
		if (flag.equals("11") || flag.equals("01")) {

		}

			// System.out.println("send info to client:" + sendContent);

    }
 
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}