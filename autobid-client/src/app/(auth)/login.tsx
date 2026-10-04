import { Link } from "expo-router";
import { View } from "react-native";
import { Button } from "react-native-paper";

export default function Login() {
	return (
		<View>
			<Link href="/(auth)/register" push asChild>
				<Button>Register</Button>
			</Link>
			<Link href="/(app)/dashboard" push asChild>
				<Button>Login User</Button>
			</Link>
		</View>
	);
}
