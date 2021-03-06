package gtv.andrew.crossedlines.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import gtv.andrew.crossedlines.Game;
import gtv.andrew.crossedlines.R;

public class NewGameDialog extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Game.Instance().mediaPlayerMenu.start();
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.dialog_new_game, null);
		builder.setView(view)
				.setTitle("New Game");
		return builder.create();
	}

}