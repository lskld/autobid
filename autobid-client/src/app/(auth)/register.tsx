import { Link } from "expo-router";
import { useState } from "react";
import { StyleSheet, View } from "react-native";
import { Button, Text, TextInput } from "react-native-paper";
import { SafeAreaView } from "react-native-safe-area-context";

export default function Register() {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");

	return (
		<SafeAreaView style={styles.container}>
			<Text style={styles.h1}>Welcome to Autobid!</Text>
			<View style={styles.form}>
				<TextInput
					mode="outlined"
					label={"Email"}
					value={email}
					onChangeText={(email) => setEmail(email)}
					theme={{ roundness: 30 }}
				/>
				<TextInput
					mode="outlined"
					label={"Password"}
					value={password}
					onChangeText={(password) => setPassword(password)}
					secureTextEntry
					theme={{ roundness: 30 }}
				/>
			</View>
			<Link style={styles.registerBtn} href="/(app)/dashboard" push asChild>
				<Button mode="contained">Register</Button>
			</Link>
			<Link href="/(auth)/login" replace asChild>
				<Button>Already have an account? Login here</Button>
			</Link>
		</SafeAreaView>
	);
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		margin: 30,
		alignItems: "center",
		justifyContent: "center",
	},
	form: {
		gap: 5,
		width: "100%",
	},
	h1: {
		textAlign: "center",
		fontWeight: 700,
		fontSize: 20,
		marginBottom: 30,
	},
	registerBtn: {
		width: "50%",
		marginTop: 15,
	},
});
