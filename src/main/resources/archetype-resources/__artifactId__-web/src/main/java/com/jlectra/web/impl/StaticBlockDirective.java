package com.jlectra.web.impl;

import com.jlectra.web.blocks.Block;
import com.jlectra.web.blocks.Static;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.parser.node.Node;

import javax.inject.Inject;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * @author ANER0310
 *         Date: 9/25/13
 */
public class StaticBlockDirective extends GuiceReadyDirective{
	Block block;

    public StaticBlockDirective(){
        super();
    }

	@Override
	public String getName() {
		return "static";
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(final InternalContextAdapter context,
						  Writer writer, final Node node)
			throws IOException, ResourceNotFoundException,
			ParseErrorException,
			MethodInvocationException
	{
		StringWriter result = new StringWriter();

		try{
			final int paramsCount = node.jjtGetNumChildren();

			result.write(block.process(new ArrayList<String>(paramsCount + 1){{
				for(int i = 0; i < paramsCount; i++){
					add(String.valueOf(node.jjtGetChild(i).value(context)));
				}
			}}));
		} catch (Throwable e){
			result.write("<pre> Unable to insert a block: \n\t" + e.getMessage() + "\n\n");
			e.printStackTrace(new PrintWriter(result));
			result.write("</pre>");
		}

		writer.write(result.toString());

		return true;
	}

	@Inject
	public void setBlock(@Static Block block){

	}
}