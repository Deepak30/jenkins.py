package jenkins.python.expoint;


import hudson.ExtensionPoint;
import hudson.Plugin;
import hudson.DescriptorExtensionList;
import hudson.model.Descriptor.FormException;
import jenkins.model.Jenkins;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.export.ExportedBean;
import hudson.model.*;
import hudson.model.UserProperty.*;
import jenkins.python.DataConvertor;
import jenkins.python.PythonExecutor;

/**
 * This class was automatically generated by the PWM tool on 2014/03/21.
 * @see hudson.model.UserProperty
 */
public abstract class UserPropertyPW extends UserProperty {
	private transient PythonExecutor pexec;

	private void initPython() {
		if (pexec == null) {
			pexec = new PythonExecutor(this);
			String[] jMethods = new String[0];
			String[] pFuncs = new String[0];
			Class[][] argTypes = new Class[0][];
			pexec.checkAbstrMethods(jMethods, pFuncs, argTypes);
			String[] functions = new String[2];
			functions[0] = "get_descriptor";
			functions[1] = "reconfigure";
			int[] argsCount = new int[2];
			argsCount[0] = 0;
			argsCount[1] = 2;
			pexec.registerFunctions(functions, argsCount);
		}
	}

	@Override
	public UserPropertyDescriptor getDescriptor() {
		initPython();
		if (pexec.isImplemented(0)) {
			return (UserPropertyDescriptor) pexec.execPython("get_descriptor");
		} else {
			return super.getDescriptor();
		}
	}

	@Override
	public UserProperty reconfigure(StaplerRequest req, JSONObject form) throws FormException {
		initPython();
		if (pexec.isImplemented(1)) {
			return (UserProperty) pexec.execPython("reconfigure", req, form);
		} else {
			return super.reconfigure(req, form);
		}
	}

	public UserPropertyDescriptor superGetDescriptor() {
		return super.getDescriptor();
	}

	public UserProperty superReconfigure(StaplerRequest req, JSONObject form) throws FormException {
		return super.reconfigure(req, form);
	}

	public Object execPython(String function, Object... params) {
		initPython();
		return pexec.execPython(function, params);
	}

	public byte execPythonByte(String function, Object... params) {
		initPython();
		return pexec.execPythonByte(function, params);
	}

	public short execPythonShort(String function, Object... params) {
		initPython();
		return pexec.execPythonShort(function, params);
	}

	public char execPythonChar(String function, Object... params) {
		initPython();
		return pexec.execPythonChar(function, params);
	}

	public int execPythonInt(String function, Object... params) {
		initPython();
		return pexec.execPythonInt(function, params);
	}

	public long execPythonLong(String function, Object... params) {
		initPython();
		return pexec.execPythonLong(function, params);
	}

	public float execPythonFloat(String function, Object... params) {
		initPython();
		return pexec.execPythonFloat(function, params);
	}

	public double execPythonDouble(String function, Object... params) {
		initPython();
		return pexec.execPythonDouble(function, params);
	}

	public boolean execPythonBool(String function, Object... params) {
		initPython();
		return pexec.execPythonBool(function, params);
	}

	public void execPythonVoid(String function, Object... params) {
		initPython();
		pexec.execPythonVoid(function, params);
	}
}